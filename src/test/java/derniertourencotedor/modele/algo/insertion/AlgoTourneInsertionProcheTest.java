package derniertourencotedor.modele.algo.insertion;

import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.algo.AlgoTourne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTourneInsertionProcheTest
{
    @Test
    public void testEffectuerTourner() throws FileNotFoundException
    {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne tourneeInsertionProche = new AlgoTourneInsertionProche(villesParserAvecFichier);
        Tourne tourne = tourneeInsertionProche.effectuerTourne();
        float coutObtenu = tourne.getCout();
        Assert.assertEquals(618.10, coutObtenu, 0.1f);
    }
}