package maquinacafe;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/** La clase Cafetera simula el comportamiento de una máquina que dispensa
 *  café.
 *  
 *
 */
public class Cafetera {
	public static final int NUM_RECETAS = 1;
	
	private HashMap<String, Receta> recetario;
	private Inventario inventario;
	
	public Cafetera() {
		recetario = new HashMap<String, Receta>();
	}
		
	public void setInventario(Inventario inventario){
		this.inventario = inventario;
	}
	/**
	 * Se añade la receta indicada al libro de recetas. Se tiene que cumplir
	 * que no exista una receta con el mismo nombre y que no exceda 
	 * la cantidad de recetas establecidas.
	 * 
	 * @param receta receta que se va a añadir.
	 * @return true si la receta se ha añadido al libro de recetas, 
	 *         false en caso contrario.
	 */
	public boolean addReceta(Receta receta) {
		if (receta == null) {
			return false;
		}
		if (recetario.containsKey(receta.getNombre())) {
			return false;
		}
		if (recetario.size() >= NUM_RECETAS) {
			return false;
		}
		recetario.put(receta.getNombre(), receta);
		return true;
	}
	

	/**
	 * Modifica la receta cuyo nombre se pasa como parámetro. 
	 * Se modifica de acuerdo a los valores de la nueva receta.
	 * 
	 * @param nombreReceta receta que se va a modificar.
	 * @param nuevaReceta nuevos valores que modifican la receta.
	 * @return devuelve la receta con los nuevos valores 
	 *         o null si no se ha modificado.
	 * @throws IllegalArgumentException si el el nombre de la nuevaReceta
	 * 			 no coincide con el de la receta a modificar o los parámetros son nulos
	 */
	public Receta editarReceta(String nombreReceta, Receta nuevaReceta) {
		if (nombreReceta == null || nuevaReceta == null)
			throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
		
		if (!nombreReceta.equals(nuevaReceta.getNombre())) {
			throw new IllegalArgumentException("El nombre de la nueva receta no coincide con el nombre de la receta a modificar");
		}
		
		if (recetario.containsKey(nombreReceta)) {
		
			recetario.put(nombreReceta, nuevaReceta);
			return nuevaReceta;
		
		} else { 
		
			return null;
		}
	}
	
	/**
	 * Devuelve las recetas configuradas en la máquina de café.
	 * @return colección de recetas.
	 */
	public Collection<Receta> getRecetas() {
		return Collections.unmodifiableCollection(recetario.values());
	}
	
	/**
	 * Simula el evento de dispensar la bebida seleccionada. 
	 *    1) La bebida seleccionada tiene que estar en el recetario,
	 *    2) se tiene que haber insertado el dinero suficiente y 
	 *    3) tiene que haber suficientes ingredientes para preparla.
	 *    
	 * @param nombreReceta bebida que se quiere comprar.
	 * @param dinero dinero que se introduce en la máquina.
	 * @return dinero que devuelve 
	 *         o el dinero introducido si no se puede dispensar.
	 */
	public int hacerCafe(String nombreReceta, int dinero) {
		Receta receta = recetario.get(nombreReceta);
		
		if (receta == null) {
			//La receta no está en el recetario
			return dinero;
		
		} else 	if (receta.getPrecio() > dinero) {
		    //No he insertado dinero suficiente
			return dinero;
		
		} else if (!inventario.hayIngredientes(receta)) {
			//No hay suficientes ingredientes
			return dinero;
		
		} else {
			//Se dispensa la bebida y se devuelve el cambio
			inventario.usarIngredientes(receta);
			//FIXME return receta.getPrecio();
			return Math.abs(receta.getPrecio() - dinero);
		}	
	}

}
