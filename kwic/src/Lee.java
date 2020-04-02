import java.io.*;
//import java.net.URL;
import es.uned.master.java.basico.KwicExceptionPropia;

/**
 * @author d¡ego valera hernandez
 * clase que lee el fichero noclaves y lo almacena en un string
 */
	
  //clase que devuelve un string pasandole como parametro al metodo lee un fichero de texto
  //sin constructor (por defecto se declara constructor vacio)
  class Lee{
        //variable que recoge el contenido del .txt
	    String texto="";
	 /**
	   * metodo que devuelve un string despues de aver leido un fichero .txt
	   * @param file ruta del fichero si no existe lo crea en la ruta especificada
     */
    public String LeeFrase(File file) throws IOException{
	  
	   if(file==null){		   
		   System.out.println("\n");
	 	   System.out.println(new KwicExceptionPropia().getMessage(333));
	 	   System.out.println("\n");
	   }else {		  
	      boolean ok = file.createNewFile(); 
	      
	      if(ok) { 
	        try {    
	           InputStream input = getClass().getResourceAsStream(file.getAbsolutePath());
		      	//leemos el fichero caracter a caracter y formamos texto	       
	           int c=0;
	           while(c!=-1) {
	            	c=input.read();
                    char letra=(char)c;
	                texto+=letra;       
		       } input.close();	
		   
	        } catch (IOException e) {
	            System.out.println("No se ha encontrado el archivo"+e);
	        }
	      }
	   }  
	   
	  return texto;	   
   }	
    
}
