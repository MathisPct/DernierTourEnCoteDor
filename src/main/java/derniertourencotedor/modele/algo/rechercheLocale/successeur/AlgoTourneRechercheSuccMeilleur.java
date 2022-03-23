package derniertourencotedor.modele.algo.rechercheLocale.successeur;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;

import java.util.ArrayList;

public class AlgoTourneRechercheSuccMeilleur extends AlgoTourneRechercheLocale
{
    public AlgoTourneRechercheSuccMeilleur(VillesParser villesService, Tourne tourneAOptimiser)
    {
        super(villesService, tourneAOptimiser);
    }

    @Override
    protected Tourne explorerVoisinage(Tourne tourneCourante)
    {
        ArrayList<Ville> villes = new ArrayList<>(tourneCourante.getTourneesVilles());
        Tourne voisin = new Tourne(new ArrayList<>(villes));
        Tourne meilleurVoisin = tourneCourante;
        for (int i = 0; i < voisin.tailleTourne(); i++)
        {
            Ville ville1 = voisin.getTourneesVilles().get(i);
            Ville ville2 = voisin.getTourneesVilles().get((i+1)%voisin.tailleTourne());
            meilleurVoisin = intervertirSiCoutMeilleur(meilleurVoisin, ville1, ville2);
        }
        return meilleurVoisin;
    }
}
