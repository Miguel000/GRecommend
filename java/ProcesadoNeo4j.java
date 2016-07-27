package procesarneo4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProcesadoNeo4j {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fichero_peliculas = null;
        PrintWriter pw_peliculas = null;
        FileWriter fichero_a�os = null;
        PrintWriter pw_a�os = null;
        
     // Descarga de peliculas a a trav�s del identificador.
	    archivo = new File ("C:\\Users\\Miguel\\GRecommend\\Pelis.csv");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        // Fichero de salida
        fichero_peliculas = new FileWriter("C:\\Users\\Miguel\\GRecommend\\Peliculas_TAGS.csv");
        pw_peliculas = new PrintWriter(fichero_peliculas);
        
        fichero_a�os = new FileWriter("C:\\Users\\Miguel\\GRecommend\\A�os.csv");
        pw_a�os = new PrintWriter(fichero_a�os);
        
        // Lectura del fichero
        String linea;
        ArrayList a�os = new ArrayList();
        while((linea=br.readLine())!=null){
        	
        	String [] l = linea.split(";");
        	String aux = l[0];
        	String[] aux_a;
        	if(l.length>10 && l[10].contains("|")){
        		String aux_l = l[10].replace(".", "");
        		aux_l = aux_l.replace("/", "");
        		aux_l = aux_l.replace("|", "").trim();
        		aux_a = aux_l.split(" ");
        	for(String x : aux_a)
        		if (!x.equals("")){
        			pw_peliculas.println(aux + ";" + x);
        		}
        	}
//        	pw_peliculas.println(l[0]);
//        	if(!a�os.contains(l[1])){
//        		pw_a�os.println(l[1]);
//        		a�os.add(l[1]);
//        	}
        }
        fr.close();
        pw_a�os.close();
        pw_peliculas.close();
	}

}
