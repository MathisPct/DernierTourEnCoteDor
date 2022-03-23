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
        ArrayList<Tourne> tournes = new ArrayList<>();
        for (int i = 1; i < voisin.tailleTourne() - 2; i++)
        {
            float distance1 =
                    villes.get(i - 1).distanceAvecVille(villes.get(i)) + villes.get(i+1).distanceAvecVille(villes.get(i+2));
            float distance2 =
                    villes.get(i - 1).distanceAvecVille(villes.get(i+1)) + villes.get(i).distanceAvecVille(villes.get(i+2));
            if(distance1 > distance2) tournes.add(voisin.intervertirVilles(villes.get(i), villes.get(i+1)));

        }
        //il existe un meilleur voisin
        if(tournes.size() > 0) meilleurVoisin = meilleurVoisin(tournes);
        return meilleurVoisin;
    }

    private Tourne meilleurVoisin(ArrayList<Tourne> tournes)
    {
        Tourne meilleurTourne = tournes.get(0);
        double coutMinimal = Double.POSITIVE_INFINITY;
        for(Tourne tourne: tournes)
        {
            double coutMinimalCourant = tourne.getCout();
            if(coutMinimalCourant < coutMinimal)
            {
                meilleurTourne = tourne;
                coutMinimal = coutMinimalCourant;
            }
        }
        return meilleurTourne;
    }
}
