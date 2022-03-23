package derniertourencotedor.modele.algo.rechercheLocale.echange2opt;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.algo.AlgoTournePlusProcheVoisin;
import derniertourencotedor.modele.algo.rechercheLocale.AlgoTourneRechercheLocale;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTourneEchangePremierTest
{
    @Test
    void testEffectuerTourne() throws FileNotFoundException {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne tournePlusProcheVoisin = new AlgoTournePlusProcheVoisin(villesParserAvecFichier);
        Tourne tourne = tournePlusProcheVoisin.effectuerTourne();
        AlgoTourneRechercheLocale tourneRechercheLocale =
                new AlgoTourneEchangePremier(villesParserAvecFichier, tourne);
        Tourne tourneObtenu = tourneRechercheLocale.effectuerTourne();
        float coutObtenu = tourneObtenu.getCout();
        Assert.assertEquals(562.83, coutObtenu, 0.1f);
    }
}