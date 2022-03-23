/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derniertourencotedor.modele.entite;

import java.util.Objects;

import static java.lang.Math.*;

/**
 *
 * @author math7
 */
public class Ville 
{
    private final Integer numero;

    public Integer getNumero() {
        return numero;
    }
    
    private final String nom;

    private final Double latitude;

    public Double getLatitude() {
        return latitude;
    }

    private final Double longitude;

    public Double getLongitude() {
        return longitude;
    }

    public Ville(Integer numero, String nom, Double latitude, Double longitude)
    {
        this.numero = numero;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     *Formule Haversine utilisée pour le calcul des distances :
     *D(v1,v2) = abs(r*acos( (sin(y1)*sin(y2)) + (cos(y1)*cos(y2)*cos(x1-x2)) ))
     *x1,y1 et x2,y2 sont les coordonnées des villes
     *v1 et v2 exprimées en radians ,
     *r=6371 (x = longitude, y = latitude)
     * @param villeArrive vers laquelle on veut aller
     * @return la distance entre la ville courante et la ville passée en paramètre
     */
    public float distanceAvecVille(Ville villeArrive)
    {
        assert (villeArrive!= null);
        float distance = 0f;
        int r = 6371; //radian de la terre
        //coordonnées des villes exprimées en radian
        double lon1 = Math.toRadians(this.getLongitude());
        double lon2 = Math.toRadians(villeArrive.getLongitude());
        double lat1 = Math.toRadians(this.getLatitude());
        double lat2 = Math.toRadians(villeArrive.getLatitude());
        distance =  (float) abs(r * acos( (sin(lat1) * sin(lat2))  + ( cos(lat1) * cos(lat2) * cos(lon2-lon1) ) ) );
        return distance;
    }

    /**
     * Distance entre la ville de départ et la ville d'arrivée en passant par la ville courante qui est la ville
     * qui est le détour
     * @param villeDepart du quelle on part
     * @param villeArrivee vers laquelle on veut aller
     * @return la distance en faisant le détour par la ville courante
     */
    public float coutDetour(Ville villeDepart, Ville villeArrivee)
    {
        float distanceAV = villeDepart.distanceAvecVille(this);
        float distanceVB = this.distanceAvecVille(villeArrivee);
        float distanceAB = villeDepart.distanceAvecVille(villeArrivee);
        return distanceAV + distanceVB - distanceAB;
    }

    /**
     * Calcule le cout minimum d'insertion entre i et i+1 de la ville courante
     * @param tourne contenant les villes de la tournée actuelle
     * @return le coût minimum d'insertion entre i et i+1
     */
    public float distanceAvecTourne(Tourne tourne)
    {
        float coutMinimum = Float.POSITIVE_INFINITY;
        for (int i = 0; i < tourne.getTourneesVilles().size(); i++)
        {
            Ville ville1 = tourne.getTourneesVilles().get(i);
            Ville ville2;
            //si on est à la fin de la liste on prend la première ville
            if(i == tourne.getTourneesVilles().size()-1) ville2 = tourne.getTourneesVilles().get(0);
            else ville2 = tourne.getTourneesVilles().get(i + 1);
            float coutCourant = this.coutDetour(ville1, ville2);
            if (coutCourant < coutMinimum)
            {
                coutMinimum = coutCourant;
            }
        }
        return coutMinimum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.latitude);
        hash = 67 * hash + Objects.hashCode(this.longitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ville other = (Ville) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+this.numero;
    }
}
