/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diegoa.torres
 */
public class Buscamina {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Es una constante utilizada para indicar la cantidad de filas en el nivel
     * principiante
     */
    public static final int FILAS_PRINCIPIANTE = 8;

    /**
     * Es una constante utilizada para indicar la cantidad de filas en el nivel
     * intermedio
     */
    public static final int FILAS_INTERMEDIO = 16;

    /**
     * Es una constante utilizada para indicar la cantidad de filas en el nivel
     * experto
     */
    public static final int FILAS_EXPERTO = 16;

    /**
     * Es una constante utilizada para indicar la cantidad de columnas en el
     * nivel principiante
     */
    public static final int COLUMNAS_PRINCIPIANTE = 8;

    /**
     * Es una constante utilizada para indicar la cantidad de columnas en el
     * nivel intermedio
     */
    public static final int COLUMNAS_INTERMEDIO = 16;

    /**
     * Es una constante utilizada para indicar la cantidad de columnas en el
     * nivel experto
     */
    public static final int COLUMNAS_EXPERTO = 30;

    /**
     * Es una constante utilizada para saber la dificultad del juego, representa
     * el nivel principiante
     */
    public static final int PRINCIPIANTE = 1;

    /**
     * Es una constante utilizada para saber la dificultad del juego, representa
     * el nivel intermedio
     */
    public static final int INTERMEDIO = 2;

    /**
     * Es una constante utilizada para saber la dificultad del juego, representa
     * el nivel experto
     */
    public static final int EXPERTO = 3;

    /**
     * Es una constante utilizada para saber la cantidad de minas en nivel
     * principiante
     */
    public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

    /**
     * Es una constante utilizada para saber la cantidad de minas en nivel
     * intermedio
     */
    public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

    /**
     * Es una constante utilizada para saber la cantidad de minas en nivel
     * experto
     */
    public static final int CANTIDAD_MINAS_EXPERTO = 99;

    // -----------------------------------------------------------------
    // Atributos y relaciones
    // -----------------------------------------------------------------
    /**
     * Relacion que tiene la matriz de casillas
     */
    private Casilla[][] casillas;

    /**
     * Atributo que representa el nivel del juego
     * <Solo puede tomar valores PRINCIPIANTE, INTERMEDIO, EXPERTO>
     */
    private int nivel;

    /**
     * Atributo que tiene la cantidad de minas en el tablero
     */
    private int cantidadMinas;

    /**
     * Atributo que representa si el usuario perdio al abrir una mina
     */
    private boolean perdio;
    
    
   

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructo de la clase Buscaminas
     *
     * @param nivel - el nivel seleccionado por el usuario
     */
    public Buscamina(int nivel) {
        this.nivel = nivel;
        perdio = false;
        inicializarPartida();

    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    /**
     * Se encarga de inicializar los atributos y relaciones de la clase
     * buscaminas a partir del nivel elegido por el usuario
     */
    private void inicializarPartida() {
        

        if (nivel == PRINCIPIANTE) {

            casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
            cantidadMinas = 10;
            generarMinas();
            inicializarCasillasLibres();
            
            
          
        } else if (nivel == INTERMEDIO) {

            casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
            cantidadMinas = 40;
            generarMinas();
            inicializarCasillasLibres();
            
            
        } else if (nivel == EXPERTO) {

            casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
            cantidadMinas = 99;
            generarMinas();
            inicializarCasillasLibres();
            
            
        }

    }

    /**
     * Metodo que se encarga de inicializar todas las casillas que no son minas
     */
    public void inicializarCasillasLibres() {
       
        for (int i = 0; i < casillas.length; i++) {
            
            for (int j = 0; j < casillas[0].length; j++) {
                
                if (casillas[i][j] == null) {
                    
                    casillas[i][j] = new Casilla(50);
                }
            }
        }
        
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                
                int a = cantidadMinasAlrededor(i, j);
                casillas[i][j].modificarValor(a);
            }
        }
    }

    /**
     * Metodo que permite contar la cantidad de minas que tiene alrededor una
     * casillas
     *
     * @param i - La fila de la matriz
     * @param j - la columna de la matriz
     * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
     */
    public int cantidadMinasAlrededor(int i, int j) {
        
        		
		int contador = 0; 	
		int v = 0;	
		int h = 0; 	
		
		for (int a = i - 1; v < 3 && a < casillas.length; a++) {	
			for (int b = j - 1; h < 3; b++) {		
				if ((a >= 0 && b >= 0) && (b < casillas[a].length)) {		
					if (casillas[a][b].esMina()) {			
						contador++;			
					}		
				}		
				h++;	
			}	
			v++;		
			h = 0;	
		} 	
		return contador;
    }

    /**
     * MÈtodo que se encarga de generar aleatoriomente las minas
     */
    public void generarMinas() {    
                
        int i = casillas.length;
        int j = casillas[0].length;
                
        for (int k = 0; k < cantidadMinas; k++) {
            
            int a = (int) Math.floor(Math.random()* (0 - i) + i);

            int b = (int) Math.floor(Math.random()* (0 - j) + j);
            
            boolean es = true;
            
            for (int l = 0; l < cantidadMinas && es; l++) {
                
                if (casillas[a][b] == null) {
                    
                    casillas[a][b] = new Casilla(Casilla.MINA);
                    es = false;
                }else{
                    
                    int c = (int) Math.floor(Math.random()* (0 - i) + i);

                    int d = (int) Math.floor(Math.random()* (0 - j) + j);
                    
                    casillas[c][d] = new Casilla(Casilla.MINA);
                    es = false;
                    
                }                
            }
         
        }
            
        
    }

    /**
     * Metodo que se encarga de convertir el tablero a un String para poder
     * verlo en pantalla
     *
     * @return String - El tablero en formato String
     */
    public void mostrarTablero() {

        
        
        for (int i = 0; i < casillas.length; i++) {
            
                    
            for (int j = 0; j < casillas[0].length; j++) {
                
 
             
                casillas[i][j].mostrarValorCasilla();
                
            }    
        }       
    }

    /**
     * Metodo que se encarga de marcar todas las casillas como destapadas
     */
    public void resolver() {

        for (int i = 0; i < casillas.length; i++) {
            
            for (int j = 0; j < casillas[0].length; j++) {
                
                casillas[i][j].destapar();
            }
        }
    }

    /**
     * Metodo dar del atributo casillas
     *
     * @return la relacion casillas
     */
    public Casilla[][] darCasillas() {
        return casillas;
    }

    /**
     * Este metodo se encargaa de abrir una casilla Si se abre una casilla de
     * tipo Mina, se marca que el jugador perdio el juego.
     *
     * @param i - la fila donde esta la casilla
     * @param j - la columna donde esta la casilla
     * @return boolean - true si fue posible destaparla, false en caso contrario
     */
    public boolean abrirCasilla(int i, int j) {
        
        boolean abrir = false;
        String msj =  " ";
        
        if (casillas[i][j].darSeleccionada() == false) {
            
            casillas[i][j].destapar();
            abrir = true;
            
            
            
            if (casillas[i][j].esMina() == true) {
                
                darPerdio();
            }
            
        }
        return abrir;
    }

    /**
     * Metodo que se encarga de revisar si el jugador gano el juego
     *
     * @return boolean - true si gano el juego, false en caso contrario
     */
        
       public boolean gano() {
		boolean gano = true;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (!casillas[i][j].esMina() && !casillas[i][j].darSeleccionada()) {
					gano = false;
				}
			}
		}
		return gano;
	}
    

    /**
     * Metodo que se encarga de abrir la primera casilla que no sea una Mina y
     * cuyo valor sea Mayor que 0
     *
     * @return String, Mensaje de la Casilla que marco abierta, En caso de no
     * haber casillas posibles para dar una pista, retorna el mensaje no hay
     * pistas para dar
     */
    public String darPista() {

        String msj = " ";
        
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                if (casillas[i][j].darSeleccionada() == false) {
                    if (casillas[i][j].esMina() == false) {
                        if (casillas[i][j].darValor() > 0) {
                            
                          
                           
                            msj = " La fila es: " + i++ + " Y la columna es: " + j++ + '\n';
                            
                        }
                    }
                }
            }
        }
        return msj;
    }

    /**
     * *
     * Metodo dar del atributo perdio
     *
     * @return boolean el atributo
     */
    public boolean darPerdio() {

        
        return perdio;
    }
    
    public String minas(){
        
        int contador = 0;
        
        for (int i = 0; i < casillas[0].length; i++) {
            
            for (int j = 0; j < casillas.length; j++) {
                
                if (casillas[j][i].esMina() == true) {
                    
                    contador++;
                }
            }
        }
        
        return " El numero de Minas es: " +contador;
    }    
}
