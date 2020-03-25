package test;
import static org.junit.Assert.*;

import org.junit.Test;

import es.uned.master.java.coleccion.Kwic;

     // Test con estructuras de datos cargadas a null
public class DriverTest {
	
	Kwic kwic= new Kwic();

	@Test
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

}



 