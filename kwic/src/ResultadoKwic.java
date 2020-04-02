
import java.io.*;
import es.uned.master.java.basico.KwicExceptionPropia;
import es.uned.master.java.coleccion.Kwic;
 

/**
 * @author d¡ego valera hernandez
 */

  //clase que presenta por consola el resultado de la ejecucion de la aplicacion
public class ResultadoKwic   {
	 String noclaves;
	//declaracion de variables de la clase principal
	 String frases; 
	 String texto;
	 Kwic kwic= new Kwic();  //instancia kwic de la clase Kwic para realizar llamadas a sus metodos
	/**
	 * @param noclaves String "noclaves" contiene el contenido del fichero noclaves.txt
	 */
	public ResultadoKwic(String noclaves)  {
		this.noclaves = noclaves;
	}
			 
	/**
	 * metodo que devuelve el resultado de la accion de leer los ficheros
	 * de texto noclaves y frases 
	 * @param miruta el fichero que se crea 
	 */   
	public void Resultado(File miruta) { 
    	BufferedReader br = null;
    	File miFile = null;     
    	//tratamos excepcion si fichero es null o no existe ruta
      if(noclaves==null) {
    	 KwicExceptionPropia ex = new KwicExceptionPropia();
    	 System.out.println("\n");
 	     System.out.println(ex.getMessage(333));
 	     System.out.println("\n");
      }if(miruta==null) {
    	 KwicExceptionPropia ex = new KwicExceptionPropia();
     	 System.out.println("\n");
  	     System.out.println(ex.getMessage(444));
  	     System.out.println("\n");
      }else {   	 
           try  {
        	  miFile = new File(miruta.getAbsolutePath());
        	  miFile.createNewFile();
        	  FileReader reader = new FileReader(miFile);
        	  br = new BufferedReader(reader);
	           //leemos la primera linea
              frases =  br.readLine();
	            //llamada al metodo computaNoclaves que recibre como parametro el string noclaves
	          kwic.computaNoClaves(noclaves);
               //leemos la primera linea
              frases =  br.readLine();
               //recorremos el fichero entero linea por linea	       
	          while(frases != null) {
                  //llamada al metodo computaIndice que recibre como parametro el string frases del fichero frrases
	             kwic.computaIndice(frases);
	              //iteramos hasta el final del fichero
	             frases =  br.readLine();
	          }
              br.close();
              System.out.println("Kwic:"+kwic.toString());    
	     } catch ( Exception e) {
		     System.out.println("No se ha encontrado el archivo "+e);
		     System.out.println("\n");
	         e.printStackTrace();
	     } finally {
		   try {
	     	 br.close();
	        } catch(IOException e) {
		     	System.out.println("\n");
			    System.out.println(e);
		    }
	     }
      }
    }
}

