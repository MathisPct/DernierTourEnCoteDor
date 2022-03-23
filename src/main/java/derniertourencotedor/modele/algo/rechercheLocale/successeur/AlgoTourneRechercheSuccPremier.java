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
        for (int i = 1; i < tourneCourante.tailleTourne()-2; i++)
        {
            double distance1 =
                    villes.get(i - 1).distanceAvecVille(villes.get(i)) + villes.get(i+1).distanceAvecVille(villes.get(i+2));
            double distance2 =
                    villes.get(i - 1).distanceAvecVille(villes.get(i+1)) + villes.get(i).distanceAvecVille(villes.get(i+2));
            if(distance1 > distance2) tourne.intervertirVilles(villes.get(i), villes.get(i+1));
        }
        return tourne;
    }
}
