package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTourneCroissanteTest
{
    @Test
    void testEffectuerTourne() throws FileNotFoundException {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne tournePlusProcheVoisin = new AlgoTournePlusProcheVoisin(villesParserAvecFichier);
        Tourne tourne = tournePlusProcheVoisin.effectuerTourne();
        AlgoTourne tourneRechercheLocale =
                new AlgoTourneCroissante(villesParserAvecFichier);
        Tourne tourneObtenu = tourneRechercheLocale.effectuerTourne();
        float coutObtenu = tourneObtenu.getCout();
        Assert.assertEquals(2688.19, coutObtenu, 0.1f);
    }
}