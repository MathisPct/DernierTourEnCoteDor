package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;

import java.util.ArrayList;

public class AlgoTournePlusProcheVoisin extends AlgoTourne
{
    public AlgoTournePlusProcheVoisin(VillesParser villesService)
    {
        super(villesService);
    }

    @Override
    public Tourne effectuerTourne()
    {
        Tourne tournePlusProcheVoisin = new Tourne();
        ArrayList<Ville> villesNonVisites = super.villes();

        Ville premiereVille = villesNonVisites.get(0);
        villesNonVisites.remove(premiereVille);
        //on ajoute la première ville à la liste des villes visités
        tournePlusProcheVoisin.ajouterVille(premiereVille);
        Ville villeEnCours = premiereVille;
        //tant qu'il existe un sommet non visité
        while (!villesNonVisites.isEmpty())
        {
            Ville villePlusProche = villePlusProche(villeEnCours, villesNonVisites);
            tournePlusProcheVoisin.ajouterVille(villePlusProche);
            villesNonVisites.remove(villePlusProche);
            villeEnCours = villePlusProche;
        }
        return tournePlusProcheVoisin;
    }

    private Ville villePlusProche(Ville villeDepart, ArrayList<Ville> villes)
    {
        Ville villePlusProche = villes.get(0);
        //distance entre la ville de départ et la première voisine
        float distanceMinimale = villeDepart.distanceAvecVille(villePlusProche);
        for(Ville villeVoisine: villes)
        {
            float distanceEntre2Ville = villeDepart.distanceAvecVille(villeVoisine);
            if(distanceEntre2Ville < distanceMinimale)
            {
                villePlusProche = villeVoisine;
                distanceMinimale = distanceEntre2Ville;
            }
        }
        return villePlusProche;
    }
}
