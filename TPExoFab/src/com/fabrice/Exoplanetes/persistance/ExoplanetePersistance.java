package com.fabrice.Exoplanetes.persistance;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.fabrice.Exoplanetes.Exoplanete;


public class ExoplanetePersistance 
{
	public static void write(Exoplanete exoplanete, String nomFichier) throws Exception
    {
    	nomFichier = "src/sauvegardes/" + nomFichier + ".xml";
    	
        XMLEncoder xmlEncoder =new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nomFichier)));
        xmlEncoder.writeObject(exoplanete);
        xmlEncoder.close();
    }

    public static Exoplanete read(String nomFichier) throws Exception 
    {
    	nomFichier = "src/sauvegardes/" + nomFichier;
    	
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nomFichier)));
        Exoplanete exoplanete = (Exoplanete)xmlDecoder.readObject();
        xmlDecoder.close();
        return exoplanete;
    }
}
