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
	static int numero = -1;  //para seleccionar opcion
	static int indice = 0;   //para acceder al String[]
 
	private static Scanner reader = new Scanner(System.in);//scaner para recoger datos desde teclado
	public static void main(String[] arg) throws KwicExceptionPropia,IOException {
		//declaracion de variables de la clase principal
	    //menu
	    OpcionesGUI og = new OpcionesGUI();
	    //para sacar resultado por consola
	    ResultadoKwic rk; 
	    //variable para condicion  ejecutar el bucle
	    boolean ok = true;
	    CreaFicherosVacios(); //creamos ficheros vacios
	    String noclaves=null;
	     	
	    
			//Mientras ok sea true, preguntamos al usuario
	    do{
				 
					    //muestra el menu
					 og.Opciones();	
					 //reader = new Scanner(System.in); 
					 //Recoger una variable por consola					  
				     numero = Integer.parseInt(reader.next());			    
							//opociones a elegir medinte bucle if/else if
				     if(numero==1){	
				    	        System.out.println("\n");
				    	        Lee lee = new Lee();
								rk =  new ResultadoKwic();
								noclaves = lee.LeeFrase("src/Textos/noclaves.txt");
						    	rk.Resultado(noclaves,"src/Textos/frases.txt"); 
			                   
				     }if(numero==2)  {
								System.out.println("\n");
								Lee lee = new Lee();
								rk =  new ResultadoKwic();
								noclaves = lee.LeeFrase("src/Textos/noclavesvacio.txt");
							 	rk.Resultado(noclaves,"src/Textos/frasesvacio.txt"); 
							 	System.out.println("\n");
							 	//ficheros sin datos
							 	
					    	    System.out.println(new KwicExceptionPropia().getMessage(222));
					    	    
				     }if(numero==3)  {
				    	        System.out.println("\n");
				    	        Lee lee = new Lee();
				    	        rk =  new ResultadoKwic();
				    	        noclaves = lee.LeeFrase(null);
				    	        rk.Resultado(noclaves,null); 
				    	        
				     }if(numero==4)  {
			    	        System.out.println("\n");
			    	        Lee lee = new Lee();
			    	        CreaFicherosTexto ficherousuario = new CreaFicherosTexto();
			    	         //obtenemos nombre de los ficheros
			    	        String[] array = ficherousuario.FicheroUsuario("Introduzca el nombre del fichero noclaves. ");
			    	        noclaves = lee.LeeFrase(array[indice]);
			    	        rk =  new ResultadoKwic();
			    	        indice++;
			    	        rk.Resultado(noclaves,array[indice]); 				    	        
			    	       	    	 
				     }if(numero==5) {
				    	        System.out.println("\n");
								System.out.println("Adios!      ");
								//reader.close();
								ok=false;
								break;
					    //tratamos excepcion si no es una opcion
				     }else if(numero>5 || numero<1){
				    	       // reader.close();
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
	 static void CreaFicherosVacios() {
		 File noclavesvacio = null;
	     File frasesvacio = null;
		 CreaFicherosTexto ficherosvacios = new CreaFicherosTexto();
		 ficherosvacios.CreaFicherosVacios("src/Textos/noclavesvacio.txt",noclavesvacio);
		 ficherosvacios.CreaFicherosVacios("src/Textos/frasesvacio.txt",frasesvacio);		   
	   }
}
		 

