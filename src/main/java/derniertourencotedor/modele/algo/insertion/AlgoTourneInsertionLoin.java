package derniertourencotedor.modele.algo.insertion;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;

public class AlgoTourneInsertionLoin extends AlgoTourneInsertion
{
    public AlgoTourneInsertionLoin(VillesParser villesService)
    {
        super(villesService);
    }

    @Override
    public Tourne effectuerTourne()
    {
        Tourne tourneInsertionLoin = new Tourne();
        ArrayList<Ville> villesNonVisites = new ArrayList<>(super.villes());
        //on visite les 2 villes les plus éloignes
        ArrayList<Ville> villesPlusEloignes = villesPlusEloignes(villesNonVisites);
        villesNonVisites.removeAll(villesPlusEloignes);
        villesPlusEloignes.forEach((tourneInsertionLoin::ajouterVille));
        Ville villeAInserer = null;
        double coutMax;
        double distanceCourante;
        while (!villesNonVisites.isEmpty())
        {
            coutMax = 0;
            for (Ville v: villesNonVisites)
            {
                //d(v, AB) = d(A,V) + d(V, B) - d(A, B)
                distanceCourante = v.distanceAvecTourne(tourneInsertionLoin);
                if(distanceCourante >= coutMax)
                {
                    coutMax = distanceCourante;
                    villeAInserer = v;
                }
            }
            tourneInsertionLoin.insererVilleApresVilleProche(villeAInserer);
            System.out.println(tourneInsertionLoin.getTourneesVilles());
            villesNonVisites.remove(villeAInserer);
        }
        return tourneInsertionLoin;
    }
}
