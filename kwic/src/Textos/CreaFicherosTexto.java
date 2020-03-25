/**
 * 
 */
package Textos;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import es.uned.master.java.basico.KwicException;

import java.io.BufferedWriter;


/**
 * @author d¡ego valera hernandez
 * clase para crear lso ficheros .txt y los aloja en la carpeta Textos
 */
public class CreaFicherosTexto {
	//al declararlo en la clase, es ella la encargada de cerrar el scanner cuando salgamos
	static Scanner reader = new Scanner(System.in); //reader para recoger el nombre de los ficheros por teclado
	static int indice = 0;  //para acceder a la poscion del array que contiene el nombre de los ficheros
  /**
    *constructor vacio
  */
  public CreaFicherosTexto() {}
	//creamos ficheros vacios
  /**
    * metodo que recibe la ruta el path, y el fichero file si no existe lo crea
    * con contenido vacio
    * @param ruta paht del fichero file fichero a crear
   */
	public void CreaFicherosVacios(String ruta,File file) {
		String contenido = "";
		try {
			 
			  file = new File(ruta);
			  //si no existe se crea 
			  if(!file.exists()) {
				  file.createNewFile();
			  }
			  //escribimos en el fichero
			  FileWriter fw = new FileWriter(file);
			  BufferedWriter bw = new BufferedWriter(fw);
			  bw.write(contenido);
			  bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /**
	    * metodo que devuelve el nombre un array con los nombres de los ficheros
	    * hemos introducido por teclado
	    * @param mensaje, indica el nombre o ruta del fichero que deseamos incorporar a la aplicacion y que
	    * se indican por consola, estos son los ficheros noclaves y frases, son los nombres que el proyecto 
	    * les ha asociado
	    * nos pide el nombre del fichero noclaves y despues el de frases
	  */
	 public String[] FicheroUsuario(String mensaje)  {
		    String[] miarray = new String[2]; //array devuelta con los nombres de los ficheros
		    System.out.println("\n");
		    System.out.println(mensaje); //mostramos el nombre del fichero a introducir	
			String nombreficheronoclaves = reader.nextLine();
		    File fileaux = new File(nombreficheronoclaves);
		       if(fileaux.getAbsolutePath()==null){
		    	   System.out.println("\n");
		   	       System.out.println(new KwicException(555).getMessage()); //fichero no existe
		   	       System.out.println("\n");
		       }else {	    	    
		    	    miarray[indice]=nombreficheronoclaves;
		    	    System.out.println("Introduzca el nombre del fichero frases. ");	
					String nombreficherofrases = reader.nextLine();
				    File fil= new File(nombreficherofrases);
				       if(fil.getAbsolutePath()==null){
				    	   System.out.println("\n");
				   	       System.out.println(new KwicException(555).getMessage());
			               System.out.println("\n");
				       }else {
				    	   indice++;
				    	   miarray[indice]=nombreficherofrases; 
				       }
		       }
			 
			return miarray;
	  }
 
}
