package derniertourencotedor.modele.comparator;

import derniertourencotedor.modele.entite.Ville;

import java.util.Comparator;

public class VilleIdCroissantComparator implements Comparator<Ville>
{

    /**
     * Compare une ville par leur id
     * @param ville1
     * @param ville2
     * @return la différence entre les 2 villes
     */
    @Override
    public int compare(Ville ville1, Ville ville2) {
        return ville1.getNumero() - ville2.getNumero();
    }
}
