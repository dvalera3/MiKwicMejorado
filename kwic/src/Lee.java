import java.io.*;
import java.net.URL;
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
    public String LeeFrase(String file) {
	   FileReader entrada;
	   File fileaux;
             //tratamos excepcion si es fichero null
	   if(file==null) {
	    	 System.out.println("\n");
	 	     System.out.println(new KwicExceptionPropia().getMessage(333));
	 	     System.out.println("\n");
	   }else {  
	        try {    
	        	//comprobamos que el fichero exista  
		       fileaux = new File(file);
		       if(!fileaux.exists()){
		         System.out.println("Voy a buscar el fichero ubicado en la ruta parcial  "+file);
		         URL url = getClass().getClassLoader().getResource(file);
		         fileaux = new File(url.getFile());
		         entrada = new FileReader(fileaux);
		         
		       }else {
		          entrada=new FileReader(file);	 
		       }
		        	 //leemos el fichero caracter a caracter y formamos texto	       
	           int c=0;
	           while(c!=-1) {
	            	c=entrada.read();
                    char letra=(char)c;
	                texto+=letra;
	           }
	          
		       entrada.close();	
		   
	        } catch (IOException e) {
	            System.out.println("No se ha encontrado el archivo"+e);
	        }
	   }
	   
	  return texto;	   
   }	
    
}
