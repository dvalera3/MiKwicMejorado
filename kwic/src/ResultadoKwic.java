
import java.io.*;
import java.net.URL;
import es.uned.master.java.basico.KwicExceptionPropia;
import es.uned.master.java.coleccion.Kwic;
 

/**
 * @author d¡ego valera hernandez
 *
 */

  //clase que presenta por consola el resultado de la ejecucion de la aplicacion
public class ResultadoKwic   {
	 
	//declaracion de variables de la clase principal
	 String frases; 
	 Kwic kwic= new Kwic();  //instancia kwic de la clase Kwic para realizar llamadas a sus metodos
	 //constructor vacio 
	public ResultadoKwic()  {}
			 
	/**
	 * metodo que devuelve el resultado de la accion de leer los ficheros
	 * de texto noclaves y frases
	 * @param noclaves contenido del string noclaves, 
	 * @param ruta path del fichero que se crea 
	 */   
	public void Resultado(String noclaves,String ruta)  {
 		FileReader reader = null;
    	BufferedReader br = null;
    	File fileaux;     
    	//tratamos excepcion si fichero es null
      if(noclaves==null || ruta == null) {
    	 KwicExceptionPropia ex = new KwicExceptionPropia();
    	 System.out.println("\n");
 	     System.out.println(ex.getMessage(444));
 	     System.out.println("\n");
      }else {
         try  {
	       //comprobamos que el fichero exista  
	       fileaux = new File(ruta);
	    
	       if(!fileaux.exists()){
	          System.out.println("voy a buscar el fichero alojado en la ruta parcial "+ruta);
	          URL url = getClass().getClassLoader().getResource(ruta);
	          fileaux = new File(url.getFile());
	          reader = new FileReader(fileaux);
	          br = new BufferedReader(reader);
	           //leemos la primera linea
              frases =  br.readLine();
	       }else { 
	            //llamada al metodo computaNoclaves que recibre como parametro el string noclaves
	          kwic.computaNoClaves(noclaves);
	          reader = new FileReader(ruta);
              br = new BufferedReader(reader);
               //leemos la primera linea
              frases =  br.readLine();
               //recorremos el fichero entero linea por linea	       
	          while(frases != null) {
                  //llamada al metodo computaIndice que recibre como parametro el string frases del fichero frrases
	             kwic.computaIndice(frases);
	              //iteramos hasta el final del fichero
	             frases =  br.readLine();
	          }
	       }
         br.close();
           //salida por consola del resultado 
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
