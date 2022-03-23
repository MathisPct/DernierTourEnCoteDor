/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derniertourencotedor.modele;

import derniertourencotedor.modele.entite.Ville;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Permet de lire et construire des villes à partir d'un fichier
 * @author Mathis Poncet
 */
public class VillesParser
{
    private final ArrayList<Ville> villes = new ArrayList<>();
    
    public ArrayList<Ville> getVilles()
    {
        return villes;
    }   

    public VillesParser(File fichierContenuVilles) throws FileNotFoundException
    {
        construireVille(fichierContenuVilles);
    }

    private void construireVille(File contenuFichierVille) throws FileNotFoundException 
    {
        Scanner scanner = new Scanner(contenuFichierVille);
        scanner.useDelimiter(" |\n");
        while (scanner.hasNext()) 
        {
            Integer id = scanner.nextInt();
            String nomVille = scanner.next();
            Double latitude = Double.valueOf(scanner.next());
            Double longitude = Double.valueOf(scanner.next());
            Ville ville = new Ville(id, nomVille, latitude, longitude);
            this.villes.add(ville);
        }
    }
}
