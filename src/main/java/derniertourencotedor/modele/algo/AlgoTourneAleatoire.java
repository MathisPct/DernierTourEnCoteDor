package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Effectue une tournée aléatoire des villes
 */
public class AlgoTourneAleatoire extends AlgoTourne
{
    public AlgoTourneAleatoire(VillesParser villesParser)
    {
        super(villesParser);
    }

    @Override
    public Tourne effectuerTourne()
    {
        ArrayList<Ville> villes = super.villes();
        Collections.shuffle(villes);
        return new Tourne(villes);
    }
}
