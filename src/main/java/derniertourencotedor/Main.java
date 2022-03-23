/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derniertourencotedor;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.FileUtils;
import derniertourencotedor.modele.algo.AlgoTourneAleatoire;
import derniertourencotedor.modele.algo.AlgoTourneCroissante;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.algo.insertion.AlgoTourneInsertionProche;
import derniertourencotedor.modele.algo.AlgoTournePlusProcheVoisin;

/**
 *
 * @author math7
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            //recherche des villes dans le fichier
            VillesParser villesService = new VillesParser(FileUtils.getFileFromPath("top80.txt"));
            Ville ville1 =villesService.getVilles().get(0);
            Ville ville2 = villesService.getVilles().get(1);
            System.out.printf("Distance entre la ville 1 et 2: %f%n", ville1.distanceAvecVille(ville2));

            //les tournées
            Tourne tourne;

            //tournée croissante
            AlgoTourneCroissante tourneCroissanteService = new AlgoTourneCroissante(villesService);
            tourne = tourneCroissanteService.effectuerTourne();
            System.out.println(tourne.toString());
            System.out.printf("Coût tournée croissante %f", tourne.getCout());

            //tournée aléatoire
            AlgoTourneAleatoire tourneAleatoireService = new AlgoTourneAleatoire(villesService);
            tourne = tourneAleatoireService.effectuerTourne();
            System.out.println(tourne.toString());
            System.out.printf("Coût tournée aléatoire %f", tourne.getCout());
            //tournée plus proche voisin
            System.out.println("\nTournée plus proche voisin");
            AlgoTournePlusProcheVoisin tournePlusProcheVoisinService =
                    new AlgoTournePlusProcheVoisin(villesService);
            tourne = tournePlusProcheVoisinService.effectuerTourne();
            System.out.println(tourne.toString());
            System.out.println(tourne.getCout());
            //tournée insertion proche
            System.out.println("\nTournée insertion proche");
            AlgoTourne tourneInsertionProche = new AlgoTourneInsertionProche(villesService);
            tourne = tourneInsertionProche.effectuerTourne();
            System.out.println(tourne.toString());
            System.out.println(tourne.getCout());
            //tournée insertion loin
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
