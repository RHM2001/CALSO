package maquinacafe;

/** La clase Receta representa la receta de una de las bebidas que se preparan
 *  en la máquina dispensadora.
 *  
 *
 */
public class Receta {
	private final String nombre;
	private final int precio;
	private final int ctdCafe;
	private final int ctdLeche;
	private final int ctdAzucar;
	private final int ctdChocolate;
	
	
	public Receta(String nombre, int precio, int ctdCafe, int ctdLeche,
			int ctdAzucar, int ctdChocolate) {
		
		if (nombre == null || nombre.equals("")) {
			throw new IllegalArgumentException("El nombre tiene que ser significativo");
		}
		
		if (precio < 0) {
			throw new IllegalArgumentException("el precio tiene que ser una cantidad positiva");
		}
		
		if (ctdCafe < 0) {
			throw new IllegalArgumentException("La cantidad de cafe tiene que ser una cantidad positiva");
		}
		
		if (ctdLeche < 0) {
			throw new IllegalArgumentException("La cantidad de leche tiene que ser una cantidad positiva");
		}
		
		if (ctdAzucar < 0) {
			throw new IllegalArgumentException("La cantidad de azucar tiene que ser una cantidad positiva");
		}
		
		if (ctdChocolate < 0) {
			throw new IllegalArgumentException("La cantidad de chocolate tiene que ser una cantidad positiva");
		}
		
		this.nombre = nombre;
		this.precio = precio;
		this.ctdCafe = ctdCafe;
		this.ctdLeche = ctdLeche;
		this.ctdAzucar = ctdAzucar;
		this.ctdChocolate = ctdChocolate;
	}


	public int getPrecio() {
		return precio;
	}


	public int getCtdCafe() {
		return ctdCafe;
	}


	public int getCtdLeche() {
		return ctdLeche;
	}


	public int getCtdAzucar() {
		return ctdAzucar;
	}


	public int getCtdChocolate() {
		return ctdChocolate;
	}

	public String getNombre() {
		return nombre;
	}
	
}
