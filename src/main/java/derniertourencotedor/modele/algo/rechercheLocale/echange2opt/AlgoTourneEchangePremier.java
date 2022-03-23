package derniertourencotedor.modele.algo.rechercheLocale.echange2opt;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;

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
        boolean trouve = false;
        for (int i = 0; i < tourneCourante.tailleTourne() && !trouve; i++)
        {
            for (int j = i+2; j < tourneCourante.tailleTourne() && !trouve; j++)
            {
                //toute position j > i+1

                    double distance1 =
                            villes.get(i).distanceAvecVille(villes.get(i+1)) + villes.get(j).distanceAvecVille(villes.get((j+1)%tourneCourante.tailleTourne()));
                    double distance2 =
                            villes.get(i).distanceAvecVille(villes.get(j)) + villes.get(i+1).distanceAvecVille(villes.get((j+1)%tourneCourante.tailleTourne()));
                    if(distance1 > distance2)
                    {
                        tourne.retournerTroncon(i+1, j);
                        trouve = true;
                    }

            }
        }
        return tourne;
    }
}
