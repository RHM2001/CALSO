package subastas;

/**
 * Una subasta mínima es un tipo de subasta que se caracteriza porque sólo podrá ejecutarse 
 * si la puja mayor alcanza una cantidad mínima fijada en el momento de construir la subasta.
 */
public class SubastaMinima extends Subasta {
	private double cantidadMinima;

	public SubastaMinima(Usuario propietario, String producto,
			double cantidadMinima) {
		super(propietario, producto);
		
		this.cantidadMinima = cantidadMinima;
	}
	
	public double getCantidadMinima() {
		return cantidadMinima;
	}
	
	public void setCantidadMinima(double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	
	@Override
	public boolean ejecutar() {
		if (getPujaMayor() == null || 
				getPujaMayor().getCantidad() < cantidadMinima){
			//No se puede ejecutar si no se alcanza la cantidad mínima		
			return false;
		}
		else{
			//He alcanzado el mínimo fijado en el constructor
			return super.ejecutar();
		}
	}
	
	/**
	 * Una subasta mínima puede ser cerrada en cualquier momento
	 */
	public void cerrar(){
		if (!isAbierta())
			throw new IllegalArgumentException("La subasta ya está cerrada");
		
		setAbierta(false);
	}
	
}
