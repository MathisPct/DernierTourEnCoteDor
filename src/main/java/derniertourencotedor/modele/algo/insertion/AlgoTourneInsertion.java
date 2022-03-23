package derniertourencotedor.modele.algo.insertion;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.algo.AlgoTourne;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AlgoTourneInsertion extends AlgoTourne
{
    public AlgoTourneInsertion(VillesParser villesService)
    {
        super(villesService);
    }

    public abstract Tourne effectuerTourne();

    /**
     * Renvoie les 2 villes les plus éloignées d'une ville
     * @param villes où l'on cherche les 2 villes les plus éloignées
     * @return la liste des villes les plus éloignées
     */
    protected ArrayList<Ville> villesPlusEloignes(ArrayList<Ville> villes)
    {
        Ville villePlusEloigne1 = villes.get(0);
        Ville villePlusEloigne2 = villes.get(1);
        float distanceMax = 0;
        for (int i = 0; i < villes.size() - 1; i++)
        {
            for (Ville ville : villes) {
                float distanceCourante = villes.get(i).distanceAvecVille(ville);
                if (distanceCourante > distanceMax) {
                    distanceMax = distanceCourante;
                    villePlusEloigne1 = villes.get(i);
                    villePlusEloigne2 = ville;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(villePlusEloigne1, villePlusEloigne2));
    }
}
