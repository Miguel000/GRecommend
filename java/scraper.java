package scraper;

import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class scraper {

	public static void main(String[] args) throws IOException {
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fichero = null;
        PrintWriter pw = null;
		// Descarga de peliculas a a trav�s del identificador.
	    archivo = new File ("C:\\Users\\Miguel\\GRecommend\\indices_min.txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);

        fichero = new FileWriter("C:\\Users\\Miguel\\GRecommend\\Pelis.csv");
        pw = new PrintWriter(fichero);
        
        // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null){
		// TODO Auto-generated method stub
		List<String> tags = new ArrayList<String>();
		Document doc = null;
		try {
			doc = Jsoup.connect("http://www.filmaffinity.com/es/film"+linea+".html").get();	
				
			// Formato csv:
			// Titulo,a�o, duracion,pa�s,Director,Gui�n,M�sica,Fotograf�a,Reparto
			Element content = doc.getElementById("left-column");
			String linea_wr = content.text();
			linea_wr = linea_wr.replaceAll("T�tulo original ", "");
			linea_wr = linea_wr.replaceAll(" A�o ", ";");
			linea_wr = linea_wr.replaceAll(" Duraci�n ", ";");
			linea_wr = linea_wr.replaceAll(" Pa�s ", ";");
			linea_wr = linea_wr.replaceAll(" Director ", ";");
			linea_wr = linea_wr.replaceAll(" Gui�n ", ";");
			linea_wr = linea_wr.replaceAll(" M�sica ", ";");
			linea_wr = linea_wr.replaceAll(" Fotograf�a ", ";");
			linea_wr = linea_wr.replaceAll(" Reparto ", ";");
			linea_wr = linea_wr.replaceAll(" Productora ", ";");
			linea_wr = linea_wr.replaceAll(" G�nero ", ";");
			linea_wr = linea_wr.replaceAll(" Sinopsis ", ";");
			int fin = linea_wr.indexOf("(FILMAFFINITY)");
			try{
			linea_wr.substring(fin, linea_wr.length());
			pw.println(linea_wr);
			}catch (java.lang.StringIndexOutOfBoundsException e){
				System.out.println(e.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
        }
        fr.close();
        pw.close();
	}

}
