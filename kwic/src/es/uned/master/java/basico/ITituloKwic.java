/**
 * @author diego valera hernandez
 */
package es.uned.master.java.basico;

// Interfaz ItituloKwic
public interface ITituloKwic {
	
  /**
   * funcion equals(Object o) que recibe un objeto y comprueba si es del tipo TituloKwic 
   * @param o de tipo objeto
   * @return un valor verdadero o falso despues de haber echo la comprobacion
   */
  public boolean equals(Object o);
 
  /**
   * funcion hasCode() que devuelve un valor entero
   * @return devuelve un valor de tipo entero
   */
  public int hasCode();
  
  /**
   * @param tk del tipo TituloKwic
   * @return devuelve un entero
   */
  public int compareTo(TituloKwic tk);
	
  /**
   * funcion toString() que devuelve una cadena de caracteres en mayusculas
   * @return devuelve una cadena de caracteres
   */
  public String toString();
  
  /**
   * funcion reemplaza(String frase) que devuelve un string	
   * @param frase derl tipo string
   * @return devuelve una cadena de caracteres del tipo string
   */
  public String reemplaza(String frase);	

}
