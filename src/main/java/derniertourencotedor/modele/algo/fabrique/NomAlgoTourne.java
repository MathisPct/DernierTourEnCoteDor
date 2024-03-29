package derniertourencotedor.modele.algo.fabrique;

/**
 * Enumération des algos utilisables pour la tournée
 * @author Mathis Poncet
 */
public enum NomAlgoTourne
{
    ALEATOIRE("Aléatoire"),
    PLUSPROCHEVOISIN("Plus proche voisin"),
    CROISSANTE("Croissante"),
    RECHERCHE2OPTMEILLEUR("Recherche 2opt meilleur"),
    RECHERCHE2OPTPREMIER("Recherche 2opt premier"),
    RECHERCHESOMMETPREMIER("Recherche sommet premier quelconque"),
    RECHERCHESOMMETMEILLEUR("Recherche sommet meilleur quelconque"),
    RECHERCHESUCCPREMIER("Recherche successeur premier"),
    RECHERCHESUCCMEILLEUR("Recherche successeur meilleur"),
    INSERTIONPROCHE("Insertion proche"),
    INSERTIONLOIN("Insertion loin");

    private final String nomAlgoTourne;

    NomAlgoTourne(String nomAlgoTourne)
    {
        this.nomAlgoTourne = nomAlgoTourne;
    }

    public String getNomAlgoTourne()
    {
        return nomAlgoTourne;
    }
}
