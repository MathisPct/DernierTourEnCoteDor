package derniertourencotedor.modele.algo.rechercheLocale;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTourne;

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

    protected abstract Tourne explorerVoisinage(Tourne tourneCourante);
}
