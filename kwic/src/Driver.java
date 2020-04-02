import Textos.*;
import es.uned.master.java.basico.KwicExceptionPropia;
import java.io.*;
import java.io.IOException;
import java.util.Scanner; //Importación del código de la clase Scanner desde la biblioteca Java

/**
 * @author diego valera hernandez
 * @version 09/03/2020/A
**/
public class Driver {
	   //declaracion de variables de la clase principal estaticas
	static int numero = -1;  //para seleccionar opcion
	static int indice = 0;   //para acceder al String[]
	static File carpeta,archivonoclaves,archivofrases,archivonoclavesvacio,archivofrasesvacio;
	static String separador = System.getProperty("file.separator"); 
	private static Scanner reader = new Scanner(System.in);//scaner para recoger datos desde teclado
	public static void main(String[] arg) throws KwicExceptionPropia,IOException {
	       	//declaracion de variables de la clase principal
	          //menu
	    OpcionesGUI og = new OpcionesGUI();
	    //para sacar resultado por consola
	    ResultadoKwic rk; 
	    //variable para condicion  ejecutar el bucle
	    boolean ok = true;
	    CreaFicheros(); //creamos ficheros vacios
	   // String noclaves=null;   
			//Mientras ok sea true, preguntamos al usuario
	    do{			 
					    //muestra el menu
					 og.Opciones();	
				        //Recoger una variable por consola					  
				     numero = Integer.parseInt(reader.next());			    
							//opociones a elegir medinte bucle if/else if
				     if(numero==1){	
				    	        System.out.println("\n");
				    	        Lee lee = new Lee();								 
						    	//noclaves = lee.LeeFrase(archivonoclaves);
						    	rk =  new ResultadoKwic(lee.LeeFrase(archivonoclaves));
						    	rk.Resultado(archivofrases); 
						  
				     }if(numero==2)  {
								System.out.println("\n");
								Lee lee = new Lee();
								rk =  new ResultadoKwic(lee.LeeFrase(archivonoclavesvacio));
								//noclaves = lee.LeeFrase(archivonoclavesvacio);
							    rk.Resultado(archivofrasesvacio); 
							 	System.out.println("\n");
							 	//ficheros sin datos							 	
					    	    System.out.println(new KwicExceptionPropia().getMessage(222));
					    	    
				     }if(numero==3)  {
				    	        System.out.println("\n");
				    	      //  Lee lee = new Lee();
				    	        rk =  new ResultadoKwic(null);
				    	      //  noclaves = lee.LeeFrase(null);
				    	        rk.Resultado(null); 
				    	        
				     }if(numero==4)  {
			    	        System.out.println("\n");
			    	        Lee lee = new Lee();
			    	        CreaFicherosTexto ficherousuario = new CreaFicherosTexto();
			    	         //obtenemos nombre de los ficheros
			    	        String[] array = ficherousuario.FicheroUsuario("Introduzca el nombre del fichero noclaves. ");
			    	       // noclaves = lee.LeeFrase(RetunFile(array[indice]));
			    	        rk =  new ResultadoKwic(lee.LeeFrase(RetunFile(array[indice])));
			    	        indice++;
			    	        rk.Resultado(RetunFile(array[indice])); 
			    	        
				     }if(numero==5) {
				    	        System.out.println("\n");
								System.out.println("Adios!      ");
								ok=false;
								break;
				     
								
								//tratamos excepcion si no es una opcion
				     }else if(numero>5 || numero<1){
				    	        System.out.println("\n");
				    	        System.out.println(new KwicExceptionPropia().getMessage(111));
					 }  
	   }while(ok);		
	    
	   
	}	
	  /**
	   * metodo estatico CreaFicherosVacioscrea ficheros sin datos
	   * accede a la clase CreaFicherosTexto y crea en la carpeta Textos del proyexto nocalvesvacio.txt y frasesvacio.txt
	   * usados para ver el comportamiento de la aplicacion con ficheros vacios. 
	   */
	 static void CreaFicheros() {
		 	     
	     carpeta = new File(System.getProperty("user.dir")+"\\"+"src"+"\\"+"Textos");
	     carpeta.mkdirs();
		 archivonoclaves = new File(carpeta.getAbsolutePath()+"\\"+"noclaves.txt");
		 archivofrases = new File(carpeta.getAbsolutePath()+"\\"+"frases.txt");
		 archivonoclavesvacio = new File(carpeta.getAbsolutePath()+"\\"+"noclavesvacio.txt");
		 archivofrasesvacio = new File(carpeta.getAbsolutePath()+"\\"+"frasesvacio.txt");
		 
		 CreaFicherosTexto ficherosvacios = new CreaFicherosTexto();
		 ficherosvacios.CreaFicherosVacios(archivonoclavesvacio);
		 ficherosvacios.CreaFicherosVacios(archivofrasesvacio);		   
	   }
	 
	 static File RetunFile(String ruta) {
		 File miruta = new File(carpeta.getAbsolutePath()+"\\"+ruta);
		 if(!miruta.exists()) {
			 miruta.mkdirs();
		 }
         return miruta;		 		 
	 }
}
		 

