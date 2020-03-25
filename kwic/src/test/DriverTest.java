package test;
import static org.junit.Assert.*;

import org.junit.Test;

import es.uned.master.java.coleccion.Kwic;

     // Test con estructuras de datos cargadas a null
public class DriverTest {
	
	Kwic kwic= new Kwic();

	@Test
	@SuppressWarnings("all")
	public void DriveTest() {
		String noclaves=null;
		String [] frases= {"arbol"};
		
		assertNotNull("El string noclaves es null", noclaves);
		
		kwic.computaNoClaves(noclaves);
		
		for (int i=0; i<frases.length;i++){
			kwic.computaIndice(frases[i]);
		}

		System.out.println("Kwic:"+kwic.toString());
			 
	}
	
	
	@Test
	@SuppressWarnings("all")
	public void DriveTest2() {
		String noclaves="a ante cabe con el y y y la contra de por mi las las si segun sobre tras y con a ante con";
		String [] frases={
		                  "El caballero rojo",
		                  "El reloj de la abadia",
		                  "Dabale arroz a la zorra el abad",
		                  "Las aguas contaminadas y claras de Jaen mi tierra",
		                  "El abad esta ciego",
		                  "El AbAd estA CiegO"
		};		
		 
		kwic.computaNoClaves(noclaves);

		for (int i=0; i<frases.length;i++){
			kwic.computaIndice(frases[i]);
		}
		
		assertNull("El string noclaves es null", noclaves);

		System.out.println("Kwic:"+kwic.toString());
	}
	
	 @Test
	 @SuppressWarnings("all")
	 public void DriveTest3() {
		String noclaves="a ante cabe con el y y y la contra de por mi las las si segun sobre tras y con a ante con";
		String [] frases={};  
			
			kwic.computaNoClaves(noclaves);
			
			for (int i=0; i<frases.length;i++){
				kwic.computaIndice(frases[i]);
			}
			
			// frases  salta el assert pues no es null, simplemente esta vacio
			assertNull("El string frases no es null", frases);

			System.out.println("Kwic:"+kwic.toString());
	}

}



 