package subastas;

/**
 * La clase Puja representa una puja en una subasta. Se caracteriza por el usuario
 * que realiza la puja y la cantidad por la que puja.
 *
 */
public class Puja{
	private final Usuario pujador;
	private final double cantidad;

	public Puja(Usuario pujador, double cantidad) {
		this.pujador = pujador;
		this.cantidad = cantidad;
	}

	public Usuario getPujador() {
		return pujador;
	}

	public double getCantidad() {
		return cantidad;
	}
}
