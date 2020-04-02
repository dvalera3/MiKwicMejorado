/**
 * 
 */
package Textos;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import es.uned.master.java.basico.KwicExceptionPropia;

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
    * @param File file fichero a crear
   */
	public void CreaFicherosVacios(File file) {
		String contenido = "";
		try {		 
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
	
	 
	  /** String mensaje, indica el nombre o ruta del fichero que deseamos incorporar a la aplicacion
	    * String[] miarray estructura de dos elementos del tipo string que albergan los nombres
	    * metodo que devuelve el nombre un array con los nombres de los ficheros
	    * hemos introducido por teclado
	    * nos pide el nombre del fichero noclaves y despues el de frase
        * @param String mensaje contiene el texto indicando el fichero a introducir en la aplicaciòn
        * @returm String[] miarray devuelve un array de dos elementos de tipo String
	    */
	 public String[] FicheroUsuario(String mensaje)  throws IOException{
		    String[] miarray = new String[2];  
		    System.out.println("\n");
		    System.out.println(mensaje); //mostramos el nombre del fichero a introducir	
			String nombreficheronoclaves = reader.nextLine();
			try {
		        File fileaux = new File(nombreficheronoclaves);
		        if(fileaux.getAbsolutePath()==null){
		    	   System.out.println("\n");
		   	       System.out.println(new KwicExceptionPropia().getMessage(555)); //fichero no existe
		   	       System.out.println("\n");
		        }else {	
		    	  while(indice<1) {
		    	    miarray[indice]=nombreficheronoclaves;
		    	    System.out.println("Introduzca el nombre del fichero frases. ");	
					String nombreficherofrases = reader.nextLine();
				    File fil= new File(nombreficherofrases);
				       if(fil.getAbsolutePath()==null){
				    	   System.out.println("\n");
				   	       System.out.println(new KwicExceptionPropia().getMessage(555));
			               System.out.println("\n");
				       }else {
				    	   indice++;
				    	   miarray[indice]=nombreficherofrases; 
				       }
		    	  }
		       }
			
			}catch(Exception e) {
				System.out.println("Menudo fallo ");
				e.printStackTrace();
			}
			return miarray;	
	  }
 
}
