package derniertourencotedor.modele.algo.rechercheLocale.echange2opt;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;

import java.util.ArrayList;

public class AlgoTourneEchangeMeilleur extends AlgoTourneRechercheLocale
{
    public AlgoTourneEchangeMeilleur(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService, tourneAOptimiser);
    }

    @Override
    protected Tourne explorerVoisinage(Tourne tourneCourante)
    {
        ArrayList<Ville> villes = new ArrayList<>(tourneCourante.getTourneesVilles());
        Tourne tourne = new Tourne(villes);
        for (int i = 0; i < tourneCourante.tailleTourne(); i++)
        {
            for (int j = i+1; j < tourneCourante.tailleTourne(); j++)
            {
                //toute position j > i+1
                double distance1 =
                        villes.get(i).distanceAvecVille(villes.get(i+1)) + villes.get(j%tourneCourante.tailleTourne()).distanceAvecVille(villes.get((j+1)%tourneCourante.tailleTourne()));
                double distance2 =
                        villes.get(i).distanceAvecVille(villes.get(j%tourneCourante.tailleTourne())) + villes.get(i+1).distanceAvecVille(villes.get((j+1)%tourneCourante.tailleTourne()));
                if(distance1 > distance2)
                    tourne.retournerTroncon(i+1, j%tourneCourante.tailleTourne());
            }
        }
        return tourne;
    }
}
