

/**
 * @author d¡ego valera hernandez
 *
 */

//clase que presenta por consola las opciones de cargar un fichero para su lectura
public class OpcionesGUI {
	
	public OpcionesGUI() {}
	
    /**
     * metodo Opciones saca por consola las opciones que se pueden llevar a cabo
     */
	public void Opciones() {
		
		System.out.println("1. "); //se carga el fichero noclaves con los valores por defecto del proyecto
		System.out.println();
		System.out.println("2. ");  //Se carga el fichero noclaves y frases sin datos
		System.out.println();
		System.out.println("3. ");  //Se carga fichero a null
		System.out.println();
		System.out.println("4. Introduzca nombre del fichero noclaves y frases. ");  //Se carga fichero a null
		System.out.println();
		System.out.println("5. Salir.    "); //sale de la aplicacion
		System.out.println();
	}

}
