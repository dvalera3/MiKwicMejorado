package es.uned.master.java.basico;

 
public class KwicException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
    private int codigoError;
    
    public KwicException(){
		super("Kwic Excepcion:\n");
	}
	public KwicException(String str){
		super("Kwic Excepcion:\n"+str);
	}
	public KwicException(String str,String noclaves){
		super("Kwic Excepcion:\n"+str+noclaves);
	}    
    public KwicException(int codigoError){
        super();
        this.codigoError=codigoError;
    }
    //metodo que devuelve un mensaje de aviso o error 
    @Override
    public String getMessage(){
         
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

