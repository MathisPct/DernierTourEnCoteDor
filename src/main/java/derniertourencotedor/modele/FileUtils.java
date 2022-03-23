/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derniertourencotedor.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Permet de faire des opérations sur des fichiers
 * @author Mathis Poncet
 */
public class FileUtils 
{
    
    private final static String PATH_RESOURCES = "src/resources/";

    public static File getFileFromPath(String nomFichier)
    {
        return new File(String.format("%s%s",PATH_RESOURCES, nomFichier));
    }
}
