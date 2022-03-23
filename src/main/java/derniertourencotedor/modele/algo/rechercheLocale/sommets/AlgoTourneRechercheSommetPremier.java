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
        for (int i = 0; i < tourneCourante.tailleTourne() - 1; i++)
        {
            for (int j = 0; j < tourneCourante.tailleTourne() - 1; j++)
            {
                tourne =
                        intervertirSiCoutMeilleur(tourne, tourne.getTourneesVilles().get(i), tourne.getTourneesVilles().get(j));
            }
        }
        return tourne;
    }

    /**
     * Interverti les 2 villes passées en paramètre si le coût après inversion et inférieure au coût avant inversion
     * @param tourneVillesNonInversees la tournée avec les ville1 et ville2 non inversées
     * @param ville1 ville à inverser avec la ville 2
     * @param ville2 ville à inverser avec la ville 1
     * @return la tournée inversée ou non inversée suivant comment s'est déroulé la condition
     */
    private Tourne intervertirSiCoutMeilleur(Tourne tourneVillesNonInversees, Ville ville1, Ville ville2)
    {
        Tourne tourneVillesInversees = new Tourne(new ArrayList<>(tourneVillesNonInversees.getTourneesVilles()));
        tourneVillesInversees.intervertirVilles(ville1, ville2);
        if(tourneVillesInversees.getCout() < tourneVillesNonInversees.getCout())
            tourneVillesNonInversees = tourneVillesInversees;
        return tourneVillesNonInversees;
    }
}
