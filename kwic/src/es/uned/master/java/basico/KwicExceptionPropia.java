/**
 * 
 */
package es.uned.master.java.basico;

/**
 * @author d¡ego valera hernandez
 *
 */
public class KwicExceptionPropia extends Exception {
	private static final long serialVersionUID = 1L;
	 
	 //constructor
	 public KwicExceptionPropia(){
	        super();
	       // this.codigoError=codigoError;
	    }
	 /**
	  * 
	  * @param codigoError indica mediante un numero el codigo asigado al error
	  * @return devuelve un string mensaje asociado al error 
	  */
	    //metodo que devuelve un mensaje de aviso o error 
	    public String getMessage(int codigoError){
	         
	        String mensaje="";
	         //inclusion de nuevos mensajes de aviso y error
	         //case recibe un codigo implicito en caso de que
	         //vaya a ocurrir una excepcion o aviso
	        switch(codigoError){
	            case 111:
	                mensaje="Error, no es una opcion valida. Numero entre 1 y 5. ";
	                break;
	            case 222:
	                mensaje="Aviso, los ficheros no contienen datos";
	                break;
	            case 333:
	                mensaje="Error, no se le ha asociado ningun objeto al fichero no claves";
	                break;
	            case 444:
	                mensaje="Error, no se le ha asociado ningun objeto al fichero frases";
	                break;
	            case 555:
	            	 mensaje="Error, no es una ruta valida o no existe el fichero";
	            	 break;   
	        }      
	         
	   return mensaje;
	}         

}
