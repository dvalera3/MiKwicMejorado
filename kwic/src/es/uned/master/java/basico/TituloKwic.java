package es.uned.master.java.basico;

import java.util.*;
import es.uned.master.java.basico.KwicExceptionPropia;

      //la clase TituloKwic implementa ITituloKwic
public class TituloKwic implements Comparable<TituloKwic>,ITituloKwic{
	//declaracion privada de string, las instancias no podran acceder a ella
	private String tk;
	
    /**
     * constructor de TituloKwic
     * @param str se le asigna al ambito de la clase 
	*/
	public TituloKwic(String str){
		this.tk= str.toUpperCase();
	}
	
	//constructor sin parametros
	public TituloKwic(){
	
	}
	
	
	/**
	 * @param o es un objeto que cambia a objetos instanciados por la clase TituloKwic y sirve para
	 * verificar si es igual al parametro privado tk.
	 * en el caso de que el o no sea un TituloKwic salta una excepcion
	 */
	 @Override
	public boolean equals(Object o){
		if (o instanceof TituloKwic){
			TituloKwic tk= (TituloKwic) o;
			return this.tk.equals(tk.toString());
		}else{
			System.out.println(new KwicExceptionPropia().getMessage(666)); //No es un titulokwic
		}
		return  false;
	}
	
	
	/**
	 * @return devuelve un entero para comprobar con equals si los objetos son iguales
	 */
	 @Override
	public int hasCode(){
		return this.tk.hashCode();
	}

	
	/**
	 * @param tk variable de tipo string para comparar con la variablke privada en su ambito de ejecucion
	 * @return devuelve un entero para comprobar si los objetos son iguales compara el parametro que recibe 
	 * la funcion y la variable privada de la clase
	 */
	 @Override
	public int compareTo(TituloKwic tk){
		return this.tk.compareToIgnoreCase(tk.toString().toUpperCase());
	}
	
    
    /**
	 * @return devuelve la variable privada tk convertida a mayusculas
	 */ 
    @Override
	public String toString(){
		return this.tk.toUpperCase();
	}
	
    /**
	 * @param frase de tipo string, cambia la frase espacio "," por los caracteres "..."
	 * verificar si es igual al parametro privado tk.
	 * @return devuelve un patron de caracteres
	 */
	@Override
	public String reemplaza(String frase){
		StringTokenizer strk = new StringTokenizer(frase," ,");
		String resultado = "";
		while (strk.hasMoreTokens()){
			String palabraAComparar= strk.nextToken();
			TituloKwic tk= new TituloKwic(palabraAComparar);
			if (this.tk.equals(tk.toString())){
				resultado += "... ";
			}else{
				resultado += palabraAComparar+" ";
			}
		}
		return resultado;
	}

}