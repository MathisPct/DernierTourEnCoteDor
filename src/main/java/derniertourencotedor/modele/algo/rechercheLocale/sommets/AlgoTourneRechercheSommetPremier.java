package derniertourencotedor.modele.algo.rechercheLocale.sommets;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;

import java.util.ArrayList;

public class AlgoTourneRechercheSommetPremier extends AlgoTourneRechercheLocale
{
    public AlgoTourneRechercheSommetPremier(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService, tourneAOptimiser);
    }

    @Override
    protected Tourne explorerVoisinage(Tourne tourneCourante)
    {
        ArrayList<Ville> villes = new ArrayList<>(tourneCourante.getTourneesVilles());
        Tourne tourne = new Tourne(villes);
        boolean trouve = false;
        for (int i = 0; i < tourneCourante.tailleTourne() && !trouve; i++)
        {
            for (int j = 0; j < tourneCourante.tailleTourne(); j++)
            {
                tourne =
                        intervertirSiCoutMeilleur(tourne, tourne.getTourneesVilles().get(i), tourne.getTourneesVilles().get(j));
                if(tourne.getCout() < tourneCourante.getCout()) trouve = true;
            }
        }
        return tourne;
    }
}
