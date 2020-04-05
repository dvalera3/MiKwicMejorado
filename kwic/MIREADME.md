# KWIC

## Enunciado Kwic

- El objetivo de esta pràctica es realizar un glosario de palabras atendiendo a su apariciòn en un conjunto de frases (KeyWord? In Context, KWIC), desechando aquellas que no se consideren significativas.

- Para ello, contaremos con:
- Ficheros .txt cuyo contenido serà leido y extraido a una estructura de datos de tipo String, èstos ficheros se crean al ejecutar la clase principal Driver, con contenidos por defecto para ejecutar la aplicaciòn  los nombres seràn noclaves.txt y frases.txt , èstos se alojaràn en la carpeta ./Textos, ademàs se crearàn dos ficheros mas sin contenido para ver el comportamiento de la aplicacòn cuando trabaja con String sin datos. Tambièn existe la posibilidad de crear ficheros por parte del usuario, y los deberà alojar en la carpeta src/Textos del proyecto, o si se ejcuta desde linea de comandos en la carpeta target/src/Textos.  Estos ficheros deberà crearlos el usuario de manera explicita y externa a la aplicaciòn. 

- Un array de String --> donde tendremos una relaciòn de frases, a partir de las cuales, deberemos obtener el correspondiente i­ndice.
- Un String --> representa las palabras no significativas(y que, por lo tanto, no aparecerÃ¡n en el listado KWIC)

Un ejemplo de String de palabras no significativas podrìa contener la siguiente lì­nea:

```
el la los las un una unos unas y o a ante bajo cabe con contra de desde en entre hacia hasta para por segÃºn sin sobre tras si no
```

El siguiente listado de tì­tulos de pelì­culas podrìa servir como ejemplo de contenido de un array de String con las frases (frase por lìnea) a partir de las cuales construir un ìndice KWIC:

```
El color del dinero
Color pùrpura
Misiòn: imposible
La misiòn
La rosa pùrpura del Cairo
El dinero llama al dinero
La rosa del azafràn
El nombre de la rosa
Toma el dinero y corre
```

El ì­ndice que se desea generar debe tener el siguiente aspecto:

AZAFRAN

  La rosa del ...

**CAIRO**

  La rosa purpura del ...

**COLOR**

  ... pùrpura

  El ... del dinero

**DINERO**

  El color del ...

  El ... llama al ...

  Toma el ... y corre

**IMPOSIBLE**

  Misiòn: ...

**MISIÒN**

  La ...

  ...: imposible

**NOMBRE**

  El ... de la rosa

PÙRPURA

  Color ...

  La rosa ... del Cairo

**ROSA**

  El nombre de la ...

  La ... del azafràn

  La ... pùrpura del Cairo

Como vemos, el ì­ndice està ordenado por palabras significativas y, por cada una de ellas, aparecen todas las frases que la contienen (ordenadas alfabèticamente), con las apariciones de la palabra sustituidas por "...".

Visto lo anterior, se pide:

- a) Definir una clase TituloKWIC que dè envoltura a una frase o tìtulo (de tipo String), y que permita ordenar y comparar frases independientemente de si èstas contienen caracteres en minìsculas o mayùsculas, asì como un mètodo para producir una cadena, a partir del tì­tulo, con las apariciones de una palabra sustituidas por â€œ...â€�.

- Definir una clase KWIC que incluya los mètodos necesarios para:

- - Leer (y almacenar) la informaciòn de las palabras no significativas,
  - Generar la estructura del ìndice a partir de un array de String (p.e. tì­tulos de pelì­culas) teniendo en cuenta las palabras no significativas leì­das previamente.

Para resolver esta pràctica vamos a realizar una primera divisiòn del problema: Tendremos las siguientes clases:

- TituloKWIC, la cual me permitirà generar cadena de caracteres sin distinguir entre mayùsculas y minìsculas.

- ITìtuloKWIC , es una interfaz que implementa a TìtuloKWIC.

- KWIC, va a ser :

- - Un Map<TituloKWIC,Set glosario
  - Set noClaves es una estructura para guardar las no claves.

![Representaciòn Kwic](https://raw.githubusercontent.com/redeskako/EjemplosJ2SE/master/MavenDocker/kwic/kwic.PNG)

El `map, serìa una clase`TreeMap`, y un`Set`serìa una clase`TreeSet`. Como vamos a implementar clases de `TreeMap` y `TreeSet`, necesito redefinir:

- `compareTo`
- `equals`
- `hasCode`
- `toString`

## Comentarios del còdigo fuente

#### contructor Kwic()

Mètodo constructor, se inicializa la estructura

```
public KWIC(){
         noClaves = new TreeSet();
         glosario = new TreeMap();
    }
```

#### palabrasNoSignificativas(String)

Esta parte del codigo tratarà exclusivamente las **noClaves**. Que metan una estructura de String y yo computarla, recibiendo el `String` noclaves.

- Uso `StringTokenizer`para coger cada palabra no significativa.
- Tomarà un token hasta que encuentre una `,` `:` `;`
- Mientras halla elementos,lo introduzco en mi conjunto.

```
public void palabrasNoSignificativas(String pns){
        StringTokenizer st = new StringTokenizer(pns," ,:;");
        while (st.hasMoreTokens()){
                noClaves.add(new TituloKWIC(st.nextToken()));
        }

    }
```

#### generarFrases(String)

- Aquì­ trataremos la parte de las palabras significativas. Ej: Si olvido de todas las frases, solo cojo una: `String str = "La silla està rota en el balcòn"`

- Tengo que coger una palabra significativa: `esta`  --> entra como clave, palabra del ìndice. Tengo que integrarla en el indice de este mapa, puede ser que exista ese indice o no exista. A la clave Hay que ponerle un envoltorio de `TituloKWIC` , lo que harà es que: `esta --> ESTA` 

- Mètodo que recibe una frase y se computa al kwic:

- 1. primer paso --> para extraer la palabra de la frase.
  2. segundo paso: Detectar si esa palabra es indice o no.
  3. tercer paso: SÃ³lamente para los indice: incluirlo en el kwic.

Utilizo el `StringTokenizer` para coger las palabras significativas que me valdrÃ¡n como Ã­ndice para mi estructura `map`

- Mientras halla elementos, cojo una palabra y la envuelvo en `TituloKWIC`.
- Si no es una palabra no significativa, significa que voy bien, lo que tengo es una palabra vàlida en este caso. En este caso, me voy a un mètodo privado que ahora comentaremos.

```
public void generarFrases(String frase){
        StringTokenizer st = new StringTokenizer(frase);

        while (st.hasMoreTokens()){
            TituloKWIC palabra = (new TituloKWIC(st.nextToken()));
            if (!noClaves.contains(palabra)){
                //mÃ©todo privado
                frases(palabra,frase);
            }

        }
    }
```

Aqui tengo mi mètodo private, que se va a llamar frases, lo ùnico que ahora se recibe un `TituloKWIC` y un `String` que serìa la frase a introducir.

1. Creo un conjunto para el caso que ese indice no està en mi estructura.
2. Si mi estructura Map contiene ese indice, devuelveme el conjunto de frases de ese Ã­ndice.
3. Tanto si està el ì­ndice en la estructura como si no, tengo que añadir la frase al conjunto y luego relacionar ese ìndice con mi conjunto actualizado.
4. Lo saco del `if`, y no me hace falta poner un `else`.
5. Estado `replace` para que me sustituya en la frase el indice por `...`. Este mètodo està en `codigoTituloKWIC`.

```
private void frases(TituloKWIC indice,String frase){
        Set<String> s = new TreeSet<String>();
      
        if (glosario.containsKey(indice)){
            s = glosario.get(indice);
        }
        s.add(indice.replace(frase));
        glosario.put(indice,s);

    }
```

#### Mètodo toString():String

Utilizaremos dos mètodos privados:i  *`imprimirNoClaves()` --> para imprimir por pantalla el conjunto de claves.  *`imprimirGlosario()` --> para imprimir por pantalla la estructura `map`.    * `clave (ì­ndice)` y valor (conjunto de frases relacionadas y con el Ã­ndice sustituido por `...`)

```
public String toString(){
        String cadFinal = "";
        cadFinal += imprimirNoClaves();
        cadFinal += imprimirGlosario();
        return cadFinal;
    }
```

- Mètodo privado que me imprime el conjunto de las palabras no significativas. Este mÃ©todo serÃ¡ utilizado por `toString()`.	 * Utilizo el iterador de conjuntos para recorrerlo e imprimirlo.	 * Mientras halla elementos en el conjunto, imprime elementos	 * Nos devuelve los elementos imprimidos.

```
private String imprimirNoClaves(){
        String cadNoClaves = "N O    C L A V E S: "; //inicializo la cadena

        Iterator<TituloKWIC> itNoClaves = this.noClaves.iterator();
        while (itNoClaves.hasNext()){
            cadNoClaves += itNoClaves.next().toString() + ", ";
        }
        return cadNoClaves;
    }
```

- Utilizo un mètodo privado que me imprime la estructura `Map`. Este mètodo serà utilizado por `toString()`.

- - Como `map` no tiene iterator tengo que cogerlo de `map.Entry`.
  - Mientras halla elementos en mi estructura, meto el indice
  - Por cada indice llamo a un mètodo que me recorrerèr el conjunto de cada ìndice
  - El mètodo me devolverà el indice con su conjunto.

```
private String imprimirGlosario(){
        String cadGlosario = "\n"+"\n"+"         G L O S A R I O    "+"\n";
      
        Iterator<Map.Entry<TituloKWIC,Set<String>>>itGlosario = this.glosario.entrySet().iterator();
        while (itGlosario.hasNext()){
            Map.Entry<TituloKWIC,Set<String>> me = itGlosario.next();
            cadGlosario +="\n"+ me.getKey()+"\n"+"\n";
            cadGlosario += imprimirGlosario(me.getValue());
        }
        return cadGlosario;
    }
```

Utilizo un mÃ©todo que me imprime el conjunto de frases. Este mÃ©todo serÃ¡ utilizado por el mÃ©todo `imprimirGlosario()`.Hago lo mismo que hice con el conjunto formado por palabras no significativas.    * Inicializo la cadena.    * Creo el iterador.    * Mientras halla elementos, imprimo elementos.    * Devuelvo los elementos del conjunto.

```
private String imprimirGlosario(Set<String> s){
        
        String cjFrases = "";
        Iterator itCjFrases = s.iterator();
        while (itCjFrases.hasNext()){
            cjFrases += "\t" + itCjFrases.next()+ "\n";
        }
        return cjFrases;
    }
```

#### KwicExceptionPropia

Clase que maneja errores producidos durante la ejecuciòn de la clase principal, el constructor  se declara con la palabra reservada super() por si se quiere hacer uso de los mètodos definidos en la clase Excetion, en èste caso no se utiliza. El funcionamiento es:  dònde se produzca un error llamar al método getMessage pasàndole còmo paràmetro un valor de tipo int con nombre codigoError, èste es gestionado por la sentencia switch que selecciona el codigo y devuelve un mensaje de tipo String asociado al còdigo.

El nombre del mètodo que gestiona los errores es:

**

```
public**  String  getMessage(int codigoError)()   {

  String mensaje="";

​	    switch(codigoError){

​              case 111:
​	                mensaje="Error, no es una opcion valida. Numero entre 1 y 5. ";
​	                break;
​	            case 222:
​	                mensaje="Aviso, los ficheros no contienen datos";
​	                break;
​	            case 333:
​	                mensaje="Error, no se le ha asociado ningun objeto al fichero no claves";
​	                break;
​	            case 444:
​	                mensaje="Error, no se le ha asociado ningun objeto al fichero frases";
​	                break;
​	            case 555:
​	            	 mensaje="Error, no es una ruta valida o no existe el fichero";
​	            	 break;   
​	        }      

	   return mensaje;
	}         

}
```

**KwicException constructor, se inicializa la estructura

```
public KWIC(){
         noClaves = new TreeSet();
         glosario = new TreeMap();
    }
```

#### palabrasNoSignificativas(String)

Esta parte del codigo tratarÃ¡ exclusivamente las **noClaves**. Que metan una estructura de String y yo computarla, recibiend      

#### TituloKwic

constructor con paràmetro de tipo String str se le asocia al atributo de la clase token tk para la lectura de frases, transsformado a letra minùscula.

	public TituloKwic(String str){
			**this.tk= str.toUpperCase();**
		}

Mètodo equals recibe un objeto y lo tansforma a un TituloKwic pasado a letras minùsculas,si el òb jeto de es del tipo TituloKwic devuelve un mensaje de error

	public boolean equals(Object o){
		if (o instanceof TituloKwic){
			TituloKwic tk= (TituloKwic) o;
			return this.tk.equals(tk.toString());
		}else{
			throw new KwicException("No es un TituloKwic");
		}
	}

Mètodo qiue devuelve el hashCode del TituloKwic tk para comprobar con otro su igualdad	

```
public int hasCode(){
		return this.tk.hashCode();
	}
```

Mètodo que comprueba si la cadena recibida como paràmetro es igual( sin tener en cuenta letras mayùsculas o minusculas) que la variable privada de la clase, tk

```
public int compareTo(TituloKwic tk){
		return this.tk.compareToIgnoreCase(tk.toString().toUpperCase());
	}
```

Mètodo toString no recibe paràmetros y devuelve un String tk variable privada de la clase, transformada a minùsculas letra por letra 

```
public String toString(){
    	return this.tk.toUpperCase();
    }
```

Mètodo reemplaza devuelve una cadena ded caràcteres de tipo String la cual la modifica sustituyendo letras y añadiendo puntos suspensivos	

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


​	



#### Driver:

Esta es la clase principal del programa, contiene el Main y ejecuta el programa y da un resultado. Para ello cuenta con variables y objetos que son instancias de la aplicaciòn estos son los siguientes:   

- static int numero   para seleccionar opcion del menù
- static int indice   para acceder al String[] donde se recoge el nombre de los String noclaves y frases.
- static File carpeta,archivonoclaves,archivofrases,archivonoclavesvacio,archivofrasesvacio; contienen la entrada de los datos por defecto para obtener el resultado.
- private static Scanner reader = new Scanner(System.in) scaner para recoger datos desde      teclado.

Entramos en el mètodo Main, que realiza una serie de tareas iniciales para preparar el entorno   de trabajo donde vamos a selecionar una de las òpciones que nos brinda para manejar la aplicaciòn.

El orden que sigue es el siguiente:	     

1. Crea el menù con cinco òpciones diferentes utilizando la clase OpcionesGUI, 
2. Crea los ficheros que contienen los datos por defecto  mediante el mètodo CreaFicheros alojado en la clase principal.

Una vez desplegado el menù òpciones se nos presenta cinco òpciones cada una de ellas ejecuta el mètodo ***Resultado***  ubicado en la clase ***ResultadoKwic***.				

- Opcion 1: Muestra el resultado tras haber extraido del fichero noclaves.txt su contenido y cargarlo en un String mediante el mètodo *lee* de la clase *Lee* a continuaciòn se ejecuta el mètodo *Resultado* ubicado en la clase *ResultadoKwic*,  èste recibe en su variable de clase el String *noclaves* y el fichero frases.txt leyendolo mediante un flujo de lectura, y creando por cada frase del fichero un String, con èste y con el String no claves se va formando el resultado final.
- Opcion 2: Al igual que la opcion 1 pero en este caso los ficheros llamados *archivofrasesvacio* y *archivonoclavesvacio* como su nombre muy biern indica, no contienen datos. Esta òpcion es utilizada para ver el comportamiento del programa cuando utiliza String vacios.
- La opcion 3: Es igual que la opcoion 2 pero en este caso los ficheros no estan asociados a ningùn objeto y al igual que la anterior se usa para ver el comportamiento del programa con objetos cargados con **null**
- La opcion 4: nos brinda la oportunidad de introducir al sistema nuestros propios ficheros, estos se deben crear de forma  totalmente externa a la aplicaciòn, y situarlos en la carpeta src/Textos o en target/src/Textos si se quiere usar desde linea de comandos.Estos ficheros si existen seràn devueltos sus nombres en un array desde el mètodo ubicado en la clase *CreaFicherosTexto* llamado FicheroUsuario que recibe un String indicando el nombre del  fichero que deseamos buscar en la carpeta.
- La opciòn 5: es para salir del sistema.

### Lee.

Esta clase recibe el fichero que va a contener las palabras no significativas que va a guaradar en su variable de instancia **texto** . Lee el fichero mediante su mètodo *LeeFrase* recibiendo como parametro un objeto de tipo File, lee el fichero letra por letra y la va guardando en **texto** devolviendolo mediante **return**.	  

	public String LeeFrase(File file) throws IOException{
	   if(file==null){		   
		   System.out.println("\n");
	 	   System.out.println(new KwicExceptionPropia().getMessage(333));
	 	   System.out.println("\n");
	   }else {		  
	      boolean ok = file.createNewFile(); 
	      
	      if(ok) { 
	        try {    
	           InputStream input = getClass().getResourceAsStream(file.getAbsolutePath());
		      	//leemos el fichero caracter a caracter y formamos texto	       
	           int c=0;
	           while(c!=-1) {
	            	c=input.read();
	                char letra=(char)c;
	                texto+=letra;       
		       } input.close();	
		   
	        } catch (IOException e) {
	            System.out.println("No se ha encontrado el archivo"+e);
	        }
	      }
	   }  
	   
	  return texto;	   
   

### **ResultadoKwic. **

Contiene su variable de clase de tipo String llamada noclaves que es cargada mediante su constructor.

```
public ResultadoKwic(String noclaves)  {
		this.noclaves = noclaves;
	}
```

Tambièn usa una variable de tipo String: frases donde irà guardando la frase leida en cada iteraciòn.

Para ello usa su mètodo Resultado que recibe como paràmetro un objeto del tipo File.

```
 public void Resultado(File miruta) throws IOException { 
    	BufferedReader br = null;
    	File miFile = null;     
    	//tratamos excepcion si fichero es null o no existe ruta
      if(noclaves==null) {
    	 KwicExceptionPropia ex = new KwicExceptionPropia();
    	 System.out.println("\n");
 	     System.out.println(ex.getMessage(333));
 	     System.out.println("\n");
      }if(miruta==null) {
    	 KwicExceptionPropia ex = new KwicExceptionPropia();
     	 System.out.println("\n");
  	     System.out.println(ex.getMessage(444));
  	     System.out.println("\n");
      }else {   	 
           try  {
        	  miFile = new File(miruta.getAbsolutePath());
        	  miFile.createNewFile();
        	  FileReader reader = new FileReader(miFile);
        	  br = new BufferedReader(reader);
	           //leemos la primera linea
              frases =  br.readLine();
	            //llamada al metodo computaNoclaves que recibre como parametro el string noclaves
	          kwic.computaNoClaves(noclaves);
               //leemos la primera linea
              frases =  br.readLine();
               //recorremos el fichero entero linea por linea	       
	          while(frases != null) {
                  //llamada al metodo computaIndice que recibre como parametro el string frases del fichero frrases
	             kwic.computaIndice(frases);
	              //iteramos hasta el final del fichero
	             frases =  br.readLine();
	          }
              br.close();
              System.out.println("Kwic:"+kwic.toString());    
	     } catch ( Exception e) {
		     System.out.println("No se ha encontrado el archivo "+e);
		     System.out.println("\n");
	         e.printStackTrace();
	     } finally {
		   try {
	     	 br.close();
	        } catch(IOException e) {
		     	System.out.println("\n");
			    System.out.println(e);
		    }
	     }
      }
```


​    }

###  **OpcionesGUI:**

Clase que genera una sencilla y simple interfaz de usuario para seleccionar una de las opciones que nos facilita. Su constructor es vacio. Contiene un mètgodo llmado Opciones 

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
Se puede usar la aplicaciòn desde lìnea de comando mediante la orden:

**java -jar  kwic-0.0.1.jar**