package derniertourencotedor.modele.algo.insertion;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;

public class AlgoTourneInsertionProche extends AlgoTourneInsertion
{
    public AlgoTourneInsertionProche(VillesParser villesService)
    {
        super(villesService);
    }

    @Override
    public Tourne effectuerTourne()
    {
        Tourne tourneInsertionProche = new Tourne();
        ArrayList<Ville> villesNonVisites = super.villes();
        //on visite les 2 villes les plus éloignes
        ArrayList<Ville> villesPlusEloignes = villesPlusEloignes(villesNonVisites);
        villesNonVisites.removeAll(villesPlusEloignes);
        villesPlusEloignes.forEach((tourneInsertionProche::ajouterVille));
        Ville villeAInserer = null;
        double coutMinimum;
        double distanceCourante;
        while (!villesNonVisites.isEmpty())
        {
            coutMinimum = Double.POSITIVE_INFINITY;
            for (Ville v: villesNonVisites)
            {
                //on calcule la distance ajoutée à la tournée par l'insertion de v entre i et i+1
                distanceCourante = v.distanceAvecTourne(tourneInsertionProche);
                if(distanceCourante < coutMinimum)
                {
                    coutMinimum = distanceCourante;
                    villeAInserer = v;
                }
            }
            tourneInsertionProche.insererVilleApresVilleProche(villeAInserer);
            System.out.println(tourneInsertionProche.getTourneesVilles());
            villesNonVisites.remove(villeAInserer);
        }
        return tourneInsertionProche;
    }
}
