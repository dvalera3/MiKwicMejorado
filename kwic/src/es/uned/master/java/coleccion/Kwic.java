package es.uned.master.java.coleccion;
import  es.uned.master.java.basico.*;
import java.util.*;


     //utilizo interfaz ITituloKwic que es implementada por TituloKwic
public class Kwic {
	 
	//declaracion de estructuras de datos noclaves y kwic de tipo privadas
	private Set<ITituloKwic> noclaves;      
	private Map<ITituloKwic,Set<String>> kwic;

	//Consgtructor de la clase Kwic, y creacion de  las estructuras de datos
	@SuppressWarnings("all") //eliminamos avisos
	public Kwic(){
		this.noclaves= new TreeSet();
		this.kwic= new TreeMap();
		 
	}

/**
 * Esta parte tratara exclusivamente las noclaves
 * @param noclaves de tipo string se le a�ade un espacio y una coma y se a�ade a Set noclaves
 */
	public void computaNoClaves(String noclaves){
		StringTokenizer strk= new StringTokenizer(noclaves," ,");
         // interfaz utiliza la implementacion que realiza la clase TituloKwic a traves de ob
		while (strk.hasMoreTokens()){
			ITituloKwic ob = new TituloKwic(strk.nextToken());
			//this.noclaves.add(new TituloKwic(strk.nextToken()));
			this.noclaves.add(ob);
		}
	}

/**
 * Esta parte se tratara de kwic usando las noclaves como consulta
 * Tu solo vales para cuando una palabra SEA INDICE
 * Se utiliza con el compunta que recibe un String
 * @param palabra de tipo TituloKwic(interfaz que la implementa es ITituloKwic) y palabra del tipo string
 */
	@SuppressWarnings("all") //eliminamos avisos
	private void computaIndice(ITituloKwic palabra, String frase){
		//Necesariamente se añade al map.
		// Si esta -> Solo añado la frase en el Set
		// Si no está -> Además de la frase el índice
		Set<String> frases= new TreeSet();
		if (this.kwic.containsKey(palabra)){
			 // Que lo contiene
			 //Cariño dame ese valor de la palabra
			frases= this.kwic.get(palabra);
		}
		frases.add(palabra.reemplaza(frase));
		//frases.add(TituloKwic.reemplaza(palabra, frase));

		// Añadiro al map como nuevo y machaco el que había.
		this.kwic.put(palabra, frases);

	}

	 
	/**
	 * Este es yupi.
	 * metodo que recibe una frase y se computa al kwic
	 * Con mucha gracia y dos pares
	 * Tu solo vales para cuando una palabra SEA INDICE
	 * Se utiliza con el computaIndice que recibe un String
	 * @param frase de tipo string
	 */
	public void computaIndice(String frase){
		//Creo un Tokenizer para poder extraer palaba a palabra
		StringTokenizer strk= new StringTokenizer(frase," ,");

		while (strk.hasMoreTokens()){
			// Primer paso para extraer la palabra de la frase, y usamos 
			// clase TituloKwic que implementa la interfaz ITituloKwic
			ITituloKwic palabra= new TituloKwic(strk.nextToken());

			// Segundo Detectar si esa palabra es indice o no ->
			// Si la palabra es NOCLAVE no computa nada ...no se hace me voy a la bartola ...que estoy agusto
			// Dame una cerveza
			if (!(this.noclaves.contains(palabra))){
				// Tercer paso -solamente para las indice- incluirlo en el kwic
				// Ole ya llegao
				this.computaIndice(palabra, frase);
			}
		}
	}
	
	
	/**
	 * @return devuelve una cadena de a la que sele va a�adiendo una coma y un espacio
	 */ 
	private String escribeNoClaves(){
			String str="Palabras no claves: ";
			Iterator<ITituloKwic> it = this.noclaves.iterator();
			while (it.hasNext()){
				str+= it.next().toString()+", ";
			}
			return str;
		}
	
	/**
	 * @param s del tipo Set
	 * @return devuelve una cadena a la que se le va a�adiendo una tabulacion y salto a la siguiente linea
	 */ 
	private String escribeKwic(Set<String> s){
			String str="";
 			Iterator<String> it= s.iterator();
				while (it.hasNext()){
					str+= "\t"+it.next()+"\n";
				}
				return str;
	}
	
	/**
	 * @return devuelve una cadena de caracteres, str 
	 */ 
	private String escribeKwic(){
			String str="--INDICE--\n";
			  // Iterador para recorrer el mapa
			Iterator<Map.Entry<ITituloKwic,Set<String>>> it= this.kwic.entrySet().iterator();
              //recorremos el mapa
			while (it.hasNext()){
				Map.Entry<ITituloKwic,Set<String>> mp = it.next(); 
				str+= mp.getKey()+"\n"; //a�adimos salto de linea
				str+= escribeKwic(mp.getValue());
			}
			return str;
	}
	
/**
  * metodo para imprimir
  * @return devuelve una cadena de caracteres que va formando con las estructuras de datos privadas de la clase 
  */
 public String toString(){
	 String str="";
	 str+= this.escribeNoClaves();
	 str+= this.escribeKwic();
	 return str;
 }
}














