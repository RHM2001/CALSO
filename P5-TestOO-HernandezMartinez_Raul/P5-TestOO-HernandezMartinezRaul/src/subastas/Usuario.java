package subastas;

public class Usuario{
	private final static double DEFAULT_CREDITO = 0;
	
	private final String nombre;
	private double credito;
	
	public Usuario(String nombre, double credito) {
		this.nombre = nombre;
		this.credito = credito;
	}
	
	public Usuario(String nombre){
		this(nombre, DEFAULT_CREDITO);
	}

	public String getNombre() {
		return nombre;
	}

	public double getCredito() {
		return credito;
	}
	
	public void incrementarCredito(double cantidad){
		credito += cantidad;
	}
	
	public void decrementarCredito(double cantidad){
		credito -= cantidad;
	}

}
