package derniertourencotedor.modele.algo.rechercheLocale.successeur;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;

import java.util.ArrayList;

public class AlgoTourneRechercheSuccPremier extends AlgoTourneRechercheLocale
{
    public AlgoTourneRechercheSuccPremier(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService, tourneAOptimiser);
    }

    @Override
    protected Tourne explorerVoisinage(Tourne tourneCourante)
    {
        ArrayList<Ville> villes = new ArrayList<>(tourneCourante.getTourneesVilles());
        Tourne tourne = new Tourne(villes);
        boolean fini = false;
        for (int i = 0; i < tourneCourante.tailleTourne() && !fini; i++)
        {
            Ville ville1 = tourne.getTourneesVilles().get(i);
            Ville ville2 = tourne.getTourneesVilles().get((i+1)%tourne.tailleTourne());
            tourne = intervertirSiCoutMeilleur(tourne, ville1, ville2);
            //si on a trouvé une meilleure tournée
            if(tourne.getCout() < tourneCourante.getCout()) fini = true;
        }
        return tourne;
    }
}
