package derniertourencotedor.modele.algo.rechercheLocale;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.entite.Ville;

import java.util.ArrayList;

public abstract class AlgoTourneRechercheLocale extends AlgoTourne
{
    private final Tourne tourneAOptimiser;

    public Tourne getTourneAOptimiser()
    {
        return tourneAOptimiser;
    }

    public AlgoTourneRechercheLocale(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService);
        this.tourneAOptimiser = tourneAOptimiser;
    }

    @Override
    public Tourne effectuerTourne()
    {
        return rechercheLocale(getTourneAOptimiser());
    }

    public Tourne rechercheLocale(Tourne tourneAOptimiser)
    {
        Tourne tourneCourante = new Tourne(tourneAOptimiser.getTourneesVilles());
        boolean fini = false;
        Tourne tourneVoisine;
        //on cherche une tournée qui est plus optimale que la tournée courante
        while (!fini)
        {
            fini = true;
            tourneVoisine = explorerVoisinage(tourneCourante);
            //si la tournée voisine est plus optimale
            if(tourneVoisine.getCout() < tourneCourante.getCout())
            {
                tourneCourante = tourneVoisine;
                fini = false;
            }
        }
        return tourneCourante;
    }

    /**
     * Interverti les 2 villes passées en paramètre si le coût après inversion et inférieure au coût avant inversion
     * @param tourneVillesNonInversees la tournée avec les ville1 et ville2 non inversées
     * @param ville1 ville à inverser avec la ville 2
     * @param ville2 ville à inverser avec la ville 1
     * @return la tournée inversée ou non inversée suivant comment s'est déroulé la condition
     */
    protected Tourne intervertirSiCoutMeilleur(Tourne tourneVillesNonInversees, Ville ville1, Ville ville2)
    {
        Tourne tourneVillesInversees = new Tourne(new ArrayList<>(tourneVillesNonInversees.getTourneesVilles()));
        tourneVillesInversees.intervertirVilles(ville1, ville2);
        if(tourneVillesInversees.getCout() < tourneVillesNonInversees.getCout())
            tourneVillesNonInversees = tourneVillesInversees;
        return tourneVillesNonInversees;
    }

    protected abstract Tourne explorerVoisinage(Tourne tourneCourante);
}
