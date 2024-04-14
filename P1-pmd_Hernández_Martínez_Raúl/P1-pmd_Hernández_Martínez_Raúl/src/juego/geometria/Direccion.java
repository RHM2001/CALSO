package juego.geometria; 

import java.util.*;

/**
 * Enumerado de dirección
 * @author Alumno
 *
 */
public enum Direccion {
	ARRIBA, ABAJO, DERECHA, IZQUIERDA;
	
	/**
	 * Obtener la dirección opuesta de la propia dirección
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
	 * Generar una dirección aleatoria
	 * @return
	 */
	public Direccion aleatoria() {
		Direccion arrayDirecciones[] = Direccion.values();

		Random rnd = new Random();
		int indice = rnd.nextInt(4);

		return arrayDirecciones[indice];
	}
	
	
	
}