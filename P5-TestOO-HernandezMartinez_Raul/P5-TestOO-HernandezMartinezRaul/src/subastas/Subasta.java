package subastas;

import java.util.LinkedList;

/**
 * La clase Subasta simula una subasta en Internet. Un usuario registrado subasta un producto.
 * Al dar de alta la subasta (crear la subasta) ésta se encuentra en estado "ABIERTA", 
 * momento en el que se puede pujar por el producto. El propietario podrá ejecutar la subasta 
 * en cualquier momento, pasando al estado "cerrada". En este instante no se admiten más pujas, 
 * se realiza la transferencia de crédito entre el propietario y el ganador de la subasta 
 * (el usuario que ha hecho la puja mayor).
 */
public class Subasta {
	private Usuario propietario;
	private final String producto;
	private boolean abierta;
	private LinkedList<Puja> pujas;
		
	public Subasta(Usuario propietario, String producto) {
		this.propietario = propietario;
		this.producto = producto;
		abierta = true;
		pujas = new LinkedList<Puja>();
	}

	public Usuario getPropietario() {
		return propietario;
	}
	
	
	public String getProducto() {
		return producto;
	}
	
	public boolean isAbierta() {
		return abierta;
	}
		
	protected void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}

	public LinkedList<Puja> getPujas() {
		return new LinkedList<Puja>(pujas);
	}

	public Puja getPujaMayor(){
		if (pujas.isEmpty())
			return null;
		else
			return pujas.getLast();
	}
	
	/**
	 * Un usuario registrado, distinto al propietario, puja por el producto que se está
	 * subastando. La cantidad por la que se puja tiene que ser mayor que la última puja y 
	 * el usuario que realiza la puja tiene que tener crédito suficiente. 
	 * 
	 * @precondicion La subasta tiene que estar en estado ABIERTA 
	 * @param usuario usuario que puja por el producto que se está subastando
	 * @param cantidad cantidad por la que se puja por el producto
	 * @return true si la puja se ha registrado en la subasta y false en caso contrario.
	 */
	public boolean pujar(Usuario usuario, double cantidad){
		if (!isAbierta()) 
			throw new IllegalStateException("no se puede pujar si la subasta no está abierta");
		
		if (usuario == propietario) return false;
		
		if (usuario.getCredito() < cantidad) return false;
		
		if (getPujaMayor() != null &&
				getPujaMayor().getCantidad() >= cantidad) return false;
		
		Puja puja = new Puja(usuario, cantidad);
		pujas.add(puja);
		return true;
	}
	
	/**
	 * El usuario puja por un euro más que la puja mayor hasta el momento.
	 * 
	 * @see Subasta#pujar(Usuario, double)
	 * @param usuario usuario que realiza la puja
	 * @return true si la puja se ha registrado en la subasta y false en caso contrario.
	 */
	public boolean pujar(Usuario usuario){
		double cantidad;
		if (getPujaMayor() == null)
			cantidad = 1;
		else
			cantidad = getPujaMayor().getCantidad() + 1;
		
		return pujar(usuario, cantidad);
	}

	
	/**
	 * Se ejecuta la subasta, lo que implica la transferencia de crédito del ganador al propietario.
	 * 
	 * @precondición La subasta tiene que estar abierta para poder ser ejecutada
	 * @return true si la transferencia se ha llevado a cabo y false en caso contrario.
	 */
	public boolean ejecutar(){
		if (!isAbierta()) 
			throw new IllegalStateException("no se puede ejecutar si está cerrada");
		
		if (getPujaMayor() != null){
			//hacer transferencia de crédito
			Usuario ganador = getPujaMayor().getPujador();
			double cantidad = getPujaMayor().getCantidad();
			
			ganador.decrementarCredito(cantidad);
			propietario.incrementarCredito(cantidad);
			
			//cerramos la subasta
			abierta = false; 
		
			return true;
			
		} else{
			//No se ha ejecutado y por tanto no se ha cerrado
		   return false;
		}
	}
}