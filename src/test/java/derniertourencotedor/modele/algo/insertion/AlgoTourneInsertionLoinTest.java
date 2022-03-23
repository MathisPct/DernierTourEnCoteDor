package derniertourencotedor.modele.algo.insertion;

import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.entite.Tourne;
import derniertourencotedor.modele.algo.AlgoTourne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class AlgoTourneInsertionLoinTest
{
    @Test
    public void testEffectuerTourner() throws FileNotFoundException
    {
        VillesParser villesParserAvecFichier = new VillesParser(new File("top80.txt"));
        AlgoTourne tourneInsertionLoin = new AlgoTourneInsertionLoin(villesParserAvecFichier);
        Tourne tourne = tourneInsertionLoin.effectuerTourne();
        double coutObtenu = tourne.getCout();
        Assert.assertEquals(599.16, coutObtenu, 0.1f);
    }}