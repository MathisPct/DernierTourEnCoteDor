package derniertourencotedor.modele.algo.rechercheLocale.sommets;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;

import java.util.ArrayList;

public class AlgoTourneRechercheSommetMeilleur extends AlgoTourneRechercheLocale
{
    public AlgoTourneRechercheSommetMeilleur(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService, tourneAOptimiser);
    }

    @Override
    protected Tourne explorerVoisinage(Tourne tourneCourante)
    {
        ArrayList<Ville> villes = new ArrayList<>(tourneCourante.getTourneesVilles());
        Tourne tourne = new Tourne(villes);
        Tourne meilleurTourne = tourne;
        for (int i = 0; i < tourneCourante.tailleTourne(); i++)
        {
            for (int j = 0; j < tourneCourante.tailleTourne(); j++)
            {
                tourne =
                        intervertirSiCoutMeilleur(tourne, tourne.getTourneesVilles().get(i), tourne.getTourneesVilles().get(j));
                if(tourne.getCout() < tourneCourante.getCout()) meilleurTourne = tourne;
            }
        }
        return meilleurTourne;
    }
}
