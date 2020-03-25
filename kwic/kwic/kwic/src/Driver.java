import es.uned.master.java.basico.*;
import es.uned.master.java.coleccion.*;

/**
 * @author diego valera hernandez
 * @version 09/03/2020/A
**/
public class Driver {
	public static void main(String[] arg){
		//declaracion de variables de la clase principal
		Kwic kwic= new Kwic();  //instancia kwic de la clase Kwic para realizar llamadas a sus metodos 
		//declaracion de estructuras de datos
		String noclaves="a ante cabe con el y y y la contra de por mi las las si segun sobre tras y con a ante con";
		String [] frases={
		                  "El caballero rojo",
		                  "El reloj de la abadia",
		                  "Dabale arroz a la zorra el abad",
		                  "Las aguas contaminadas y claras de Jaen mi tierra",
		                  "El abad esta ciego",
		                  "El AbAd estA CiegO"
		};
         //llamada al metodo computaNoclavesque recibre como parametro el string noclaves
		kwic.computaNoClaves(noclaves);
         //bucle for para recorrer el arreglo frases
		for (int i=0; i<frases.length;i++){
			kwic.computaIndice(frases[i]);
		}
         //salida por consola del resultado 
		System.out.println("Kwic:"+kwic.toString());
	}
}
