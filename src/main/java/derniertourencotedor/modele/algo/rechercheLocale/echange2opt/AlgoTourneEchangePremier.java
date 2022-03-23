package derniertourencotedor.modele.algo.rechercheLocale.echange2opt;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;

import java.util.ArrayList;

public class AlgoTourneEchangePremier extends AlgoTourneRechercheLocale
{
    public AlgoTourneEchangePremier(VillesParser villesService, Tourne tourneAOptimiser)
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
                //toute position j > i+1
                if(j > i + 1)
                {
                    float distance1 =
                            villes.get(i).distanceAvecVille(villes.get(i+1)) + villes.get(j).distanceAvecVille(villes.get(j+1));
                    float distance2 =
                            villes.get(i).distanceAvecVille(villes.get(j)) + villes.get(i+1).distanceAvecVille(villes.get(j+1));
                    if(distance1 > distance2)
                        tourne.retournerTroncon(i+1, j);
                }
            }
        }
        return tourne;
    }
}
