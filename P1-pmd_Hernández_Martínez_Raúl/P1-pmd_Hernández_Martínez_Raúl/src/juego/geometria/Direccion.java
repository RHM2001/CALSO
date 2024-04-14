package juego.geometria; 

import java.util.*;

/**
 * Enumerado de direcci�n
 * @author Alumno
 *
 */
public enum Direccion {
	ARRIBA, ABAJO, DERECHA, IZQUIERDA;
	
	/**
	 * Obtener la direcci�n opuesta de la propia direcci�n
	 * @param direccion
	 * @return
	 */
	public Direccion opuesta(Direccion direccion) {
		switch (direccion) {
		case ARRIBA: return ABAJO;
		case ABAJO: return ARRIBA;
		case IZQUIERDA: return DERECHA;
		case DERECHA: return IZQUIERDA;
		default: return null;
		}
	}
	
	/**
	 * Generar una direcci�n aleatoria
	 * @return
	 */
	public Direccion aleatoria() {
		Direccion arrayDirecciones[] = Direccion.values();

		Random rnd = new Random();
		int indice = rnd.nextInt(4);

		return arrayDirecciones[indice];
	}
	
	
	
}