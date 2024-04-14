package maquinacafe;

import maquinacafe.Inventario;
import maquinacafe.Receta;

public class InventarioStub implements Inventario {
	
	int ctdCafe;
	int ctdLeche;
	int ctdAzucar;
	int ctdChocolate;
	
	public InventarioStub () {
		ctdCafe = 5;
		ctdLeche = 3;
		ctdAzucar = 2;
		ctdChocolate = 4;
	}

	public boolean hayIngredientes(Receta receta){
		boolean band = true;
		if(receta.getCtdCafe() > this.ctdCafe){
			band = false;
		}
		if(receta.getCtdLeche() > this.ctdLeche){
			band = false;
		}
		if(receta.getCtdAzucar() > this.ctdAzucar){
			band = false;
		}
		if(receta.getCtdChocolate() > this.ctdChocolate){
			band = false;
		}
		
		return band;
		
	}
	 
	 public void usarIngredientes(Receta receta){
		this.ctdCafe = this.ctdCafe - receta.getCtdCafe();
		this.ctdLeche = this.ctdLeche - receta.getCtdLeche();
		this.ctdAzucar = this.ctdAzucar - receta.getCtdAzucar();
		this.ctdChocolate = this.ctdChocolate - receta.getCtdChocolate();
	 }
}
