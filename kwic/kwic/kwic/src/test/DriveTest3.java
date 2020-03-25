package test;
import static org.junit.Assert.*;

import org.junit.Test;

import es.uned.master.java.coleccion.Kwic;

/**
 * 
 */

/**
 * @author d¡ego valera hernandez *
 */
public class DriveTest3 {

	@Test
 public void DriveTest3() {
	Kwic kwic= new Kwic();
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

 