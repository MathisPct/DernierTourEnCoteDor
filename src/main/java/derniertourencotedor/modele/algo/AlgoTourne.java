package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;

/**
 * Permet d'effectuer une tournée
 */
public abstract class AlgoTourne
{
    private final ArrayList<Ville> villes;

    private final VillesParser villesParser;

    /**
     * Villes avec lesquelles on va effectuer une tournée
     * @return les villes avec lesquelles on va effectuer une tournée
     */
    public ArrayList<Ville> villes()
    {
        return new ArrayList<>(villes);
    }

    public AlgoTourne(VillesParser villesParser)
    {
        this.villesParser = villesParser;
        this.villes = this.villesParser.getVilles();
    }

    /**
     * Effectue une tournée à partir de la liste des villes fournies par VillesService
     * @return la tournée à effectuer
     */
    public abstract Tourne effectuerTourne();
}
