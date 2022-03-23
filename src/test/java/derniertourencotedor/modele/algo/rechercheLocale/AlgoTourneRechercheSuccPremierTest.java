package derniertourencotedor.modele.algo.rechercheLocale;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTournePlusProcheVoisin;
import derniertourencotedor.modele.algo.AlgoTourne;
import derniertourencotedor.modele.algo.rechercheLocale.successeur.AlgoTourneRechercheSuccPremier;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTourneRechercheSuccPremierTest
{
    @Test
    void testEffectuerTournee() throws FileNotFoundException {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne tournePlusProcheVoisin = new AlgoTournePlusProcheVoisin(villesParserAvecFichier);
        Tourne tourne = tournePlusProcheVoisin.effectuerTourne();
        AlgoTourneRechercheLocale tourneRechercheLocale =
                new AlgoTourneRechercheSuccPremier(villesParserAvecFichier, tourne);
        Tourne tourneObtenu = tourneRechercheLocale.effectuerTourne();
        float coutObtenu = tourneObtenu.getCout();
        Assert.assertEquals(706.04, coutObtenu, 0.1f);
    }
}