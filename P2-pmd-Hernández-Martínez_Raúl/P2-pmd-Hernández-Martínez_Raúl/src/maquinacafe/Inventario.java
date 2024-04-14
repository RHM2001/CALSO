package maquinacafe;

import maquinacafe.Receta;;

public interface Inventario {
	 
	 public boolean hayIngredientes(Receta receta);
	 
	 public void usarIngredientes(Receta receta);
}
