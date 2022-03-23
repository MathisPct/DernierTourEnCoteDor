package derniertourencotedor.modele.algo;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTournePlusProcheVoisinTest
{
    @Test
    public void testEffectuerTourner() throws FileNotFoundException
    {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne algoTournePlusProcheVoisin = new AlgoTournePlusProcheVoisin(villesParserAvecFichier);
        Tourne tourne = algoTournePlusProcheVoisin.effectuerTourne();
        float coutObtenu = tourne.getCout();
        Assert.assertEquals(712.76, coutObtenu, 0.1f);
    }
}