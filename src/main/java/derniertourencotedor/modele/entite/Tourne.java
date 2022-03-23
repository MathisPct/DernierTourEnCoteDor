package derniertourencotedor.modele.entite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tournée des villes effectuée
 */
public class Tourne
{
    private final ArrayList<Ville> tourneesVilles;

    /**
     * Calcule la distance totale de la tournée
     * @return la distance
     */
    public float getCout()
    {
        float cout = 0f;
        for (int i = 0; i < this.tourneesVilles.size()-1; i++)
        {
            Ville ville1 = tourneesVilles.get(i);
            Ville ville2 = tourneesVilles.get(i+1);
            cout += ville1.distanceAvecVille(ville2);
        }
        //revenir au point de départ
        Ville derniereVille = tourneesVilles.get(tourneesVilles.size()-1);
        Ville premiereVille = tourneesVilles.get(0);
        cout += premiereVille.distanceAvecVille(derniereVille);
        return cout;
    }

    public ArrayList<Ville> getTourneesVilles()
    {
        return tourneesVilles;
    }



    public Tourne()
    {
        this.tourneesVilles = new ArrayList<>();
    }

    public Tourne(ArrayList<Ville> tourneesVilles)
    {
        this.tourneesVilles = tourneesVilles;
    }

    /**
     * Ajoute une ville à la tournée
     * @param villeAAjouter à ajouter à la tournée
     */
    public void ajouterVille(Ville villeAAjouter)
    {
        assert villeAAjouter != null;
        this.tourneesVilles.add(villeAAjouter);
    }

    /**
     * Interverti 2 villes dans la tournée
     * @param ville1 la ville à intervertir avec la ville2 dans la liste
     * @param ville2 la ville à intervertir avec la ville1 dans la liste
     * @return la tournée avec les 2 villes intervertits
     */
    public Tourne intervertirVilles(Ville ville1, Ville ville2)
    {
        for (int indexVille = 0; indexVille < tourneesVilles.size(); indexVille++)
        {
            if(tourneesVilles.get(indexVille).equals(ville1))
                tourneesVilles.set(indexVille, ville2);
            else if(tourneesVilles.get(indexVille).equals(ville2))
                tourneesVilles.set(indexVille, ville1);
        }
        return this;
    }

    public int tailleTourne()
    {
        return this.tourneesVilles.size();
    }

    /**
     * Permet d'insérer la ville la plus proche de la tournée existante
     * @param villeAInserer
     */
    public void insererVilleApresVilleProche(Ville villeAInserer)
    {
        float coutMinimum = Float.POSITIVE_INFINITY;
        int indexOuInsererVille = 0;
        float coutDetour;
        for(int indexVille = 0; indexVille < this.getTourneesVilles().size(); indexVille++)
        {
            Ville ville1 = this.getTourneesVilles().get(indexVille);
            Ville ville2;
            //si on est à la fin de la liste on prend la première ville
            if(indexVille == this.getTourneesVilles().size()-1) ville2 = this.getTourneesVilles().get(0);
            else ville2 = this.getTourneesVilles().get(indexVille+1);
            coutDetour = villeAInserer.coutDetour(ville1, ville2);
            if(coutDetour < coutMinimum)
            {
                coutMinimum = coutDetour;
                indexOuInsererVille = indexVille+1;
            }
        }
        this.tourneesVilles.add(indexOuInsererVille, villeAInserer);
    }

    @Override
    public String toString()
    {
        StringBuilder villes = new StringBuilder();
        for (Ville ville : tourneesVilles)
        {
           villes.append(ville.toString()).append("\n");
        }
        return villes.toString();
    }

    /**
     * Inverse un tronçon d'une tournée
     * Ex: Si on a un tronçon non inversé : Dijon-Beaune-Chenôve
     * Si l'on inverse le tronçon de la tournée, cela va donner : Chenôve-Beaune-Dijon
     * @param indexDebutTroncon début du tronçon
     * @param indexFinTroncon fin du tronçon
     */
    public void retournerTroncon(int indexDebutTroncon, int indexFinTroncon)
    {
        //on récupère les villes du tronçon à inverser
        List<Ville> tronconInverse = getTourneesVilles().subList(indexDebutTroncon, indexFinTroncon+1);
        //on inverse les villes du tronçon
        Collections.reverse(tronconInverse);
    }
}
