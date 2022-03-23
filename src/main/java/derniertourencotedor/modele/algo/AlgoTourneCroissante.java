package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.comparator.VilleIdCroissantComparator;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;

public class AlgoTourneCroissante extends AlgoTourne
{
    public AlgoTourneCroissante(VillesParser villesService)
    {
        super(villesService);
    }

    @Override
    public Tourne effectuerTourne()
    {
        ArrayList<Ville> villes = super.villes();
        villes.sort(new VilleIdCroissantComparator());
        return new Tourne(villes);
    }
}
