package derniertourencotedor.modele.entite;

import derniertourencotedor.modele.VillesParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class TourneTest {

    @Test
    void retournerTroncon()
    {
        Ville ville1 = new Ville(1, "EnDehors1", 47.3167, 5.01667);
        Ville debutTroncon = new Ville(2, "DebutTroncon", 47.3167, 5.01667);
        Ville ville3 = new Ville(3, "VilleTroncon1 ", 47.3167, 5.01667);
        Ville ville4 = new Ville(4, "VilleTroncon2 ", 47.3167, 5.01667);
        Ville finTroncon = new Ville(5, "FinTroncon ", 47.3167, 5.01667);
        Ville ville6 = new Ville(5, "EnDehors2 ", 47.3167, 5.01667);
        ArrayList<Ville> villes = new ArrayList<>(List.of(ville1, debutTroncon, ville3, ville4, finTroncon, ville6));
        Tourne tourne = new Tourne(villes);
        //on attend cette liste de villes après avoir retourné le tronçon
        ArrayList<Ville> villesApresRetournement =
                new ArrayList<>(List.of(ville1, finTroncon, ville4, ville3, debutTroncon, ville6));
        tourne.retournerTroncon(debutTroncon.getNumero()-1, finTroncon.getNumero()-1);
        Assert.assertEquals(villesApresRetournement, tourne.getTourneesVilles());
    }

    @Test
    void retournerTronconGrandeValeur() throws FileNotFoundException
    {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        ArrayList<Ville> villes = villesParserAvecFichier.getVilles();
        Tourne tourne = new Tourne(villes);
        tourne.retournerTroncon(0, 79);
        int premiereVilleListe = Optional.of(tourne.getTourneesVilles().get(0).getNumero()).get();
        int derniereVilleListe = Optional.of(tourne.getTourneesVilles().get(villes.size()-1).getNumero()).get();
        Assert.assertEquals(80, premiereVilleListe);
        Assert.assertEquals(1, derniereVilleListe);
    }
}