/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derniertourencotedor;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import derniertourencotedor.modele.entite.Ville;
import derniertourencotedor.modele.VillesParser;
import derniertourencotedor.modele.FileUtils;

/**
 *
 * @author math7
 */
public class VillesServiceTest {
    
    public VillesServiceTest() {
    }

    private VillesParser chargerVille() throws FileNotFoundException
    {
        return new VillesParser(FileUtils.getFileFromPath("top80.txt"));
    }
    
    @org.junit.jupiter.api.Test
    public void testAjoutDesVilles() throws FileNotFoundException 
    {
        Ville premiereVille = new Ville(1, "DIJON", 47.3167d, 5.01667d);
        Ville derniereVille = new Ville(80, "SANTENAY", 46.9167d, 4.68333d);
        VillesParser villesService = chargerVille();
        assertNotNull(villesService);
        assertEquals(premiereVille, villesService.getVilles().get(0));
        assertEquals(derniereVille, villesService.getVilles().get(villesService.getVilles().size()-1));
    }

    @org.junit.jupiter.api.Test
    public void distanceVillesHaversine() throws Exception
    {
        VillesParser villesService = chargerVille();
        Ville ville1 = villesService.getVilles().get(0);
        Ville ville2 = villesService.getVilles().get(1);
        assertEquals(34.42f, ville1.distanceAvecVille(ville2), 0.01);
    }
}
