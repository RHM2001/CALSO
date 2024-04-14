package juego.geometria;



/** La clase Punto representa un punto inmutable en el espacio bidimensional.
 *  Una vez creado el objeto no puede cambiar de estado.
 *
 */
public class Punto implements Cloneable {
    /**
     * Constante default
     */
    public final static int defaultValue = 0;

     final int x; // NOPMD by Raúl Hernández Martínez on 26/09/22 19:05 - Es un nombre de la variable correcta ya que es un parametro correcto de un Punto
     final int y; // NOPMD by Raúl Hernández Martínez on 26/09/22 19:03 - Es un nombre de la variable correcta ya que es un parametro correcto de un Punto

    /**
     * Constructor por defecto
     */
	// Constructor por defecto
	public Punto() {
		this (0, 0);
	
	}
	
	/**
	 * Constructor de Punto
	 * @param x
	 * @param y
	 */
	// Constructor
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor de Punto teniendo como parámetro otro punto para copiarlo
	 * @param otra
	 */
	// Constructor de copia
	public Punto(Punto otra) {
		this(otra.x, otra.y);
	}

    /** Devuelve el valor de la coordenada x
     * 
     */
    public int getX() {
        return x;
    }

    /** Devuelve el valor de la coordenada x
     * 
     */
    public int getY() {
        return y;
    }

	/** Devuelve un nuevo objeto Posicion que representa el valor de la posición
	 *  adyacente a la instancia actual en la dirección pasada como parámetro.
	 */
	public Punto Adyacente(Direccion direccion) {

		switch (direccion) {
		case DERECHA:
			return new Punto(x + 1, y); 
		case IZQUIERDA:
			return new Punto(x - 1, y); 
		case ARRIBA:
		    return new Punto(x, y + 1); 
		case ABAJO:
		    return new Punto(x, y - 1); 
		default:
		}

		return null;
	}

	/**
	 * Informa si la posición pasada como parámetro es adyacente a la instancia actual
	 * en la dirección indicada.
	 * 
	 * @return true si es adyacente y false en caso contrario.
	 */
	public Boolean isAdyacente(Punto otra, Direccion direccion) {

	    return otra.equals(Adyacente(direccion));
	}

	/**
	 * Devuelve la situación relativa de la instancia actual respecto 
	 * a la posición que se pasa como parámetro.
	 * En el caso de no ser posiciones adyacentes el 
	 * valor de retorno es null. 
	 */
	public Direccion situacion_relativa(Punto otra){
	    int difX = Math.abs(x - otra.x);
	    int difY = Math.abs(y - otra.y);

		if (difY == 1 && difX == 0)
			return Direccion.ARRIBA;
		if (difY == 1 && difX == 0)
			return Direccion.ABAJO;
		if (difY == 0 && difX == 1)
			return Direccion.IZQUIERDA;
		if (difY == 0 && difX == 1)
			return Direccion.DERECHA;
		
		return null;
	}
	
	/**
	* 
	*  Método para desplazar el punto
	*
	*/
	public Punto desplazar(int incX, int incY){
	    return new Punto(x+incX,y+incY);
	}
	
	/**
	 * Método desplazar punto dandole como parametro una direccion
	 * @param direccion
	 * @return
	 */
	public Punto desplazar(Direccion direccion){
	    switch (direccion){
	    case ARRIBA : return desplazar(0,1);
	    case ABAJO: return desplazar(0,-1);
	    case DERECHA: return desplazar(1, 0);
	    case IZQUIERDA: return desplazar(-1,0);
	    default:
	        return null;
	    }
	}

	/** Calcula la distancia entre dos posiciones.
	 *
	 */
	public double distancia (Punto posicion) {
		return Math.sqrt(Math.pow(x-posicion.getX(), 2)+Math.pow(y-posicion.getY(), 2));
	}
	
	/**
	 *
	 * Método toString()
	 * 
	 **/
	@Override
	public String toString() {
		return getClass().getName() + " [x=" + x + ", y=" + y + "]"; // NOPMD by Raúl Hernández Martínez on 26/09/22 19:09 - Ley Demeter
	}

	
	/**
	* 
	*  Método para saber si un punto es igual a otro
	* 
	* */
	public boolean equalsPunto(Punto obj) {
		if (this == obj)
			return true;

		Punto other = (Punto) obj;
		
		return  x == other.x && y == other.y;
	}

	/**
	 * 
	 *  Método clone()
	 * 
	 * */
	public Punto clone() { 
		Punto copia;

		try{
			copia = (Punto)super.clone();
			return copia;
		}
		catch(CloneNotSupportedException e){ }

		return null;
	}

}
