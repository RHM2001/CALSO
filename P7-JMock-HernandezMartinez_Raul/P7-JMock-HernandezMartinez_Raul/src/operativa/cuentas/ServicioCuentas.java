package operativa.cuentas;

public class ServicioCuentas {
	protected final static double RATIO_INTERES = 0.05;
			
	private GestorCuentas gestorCuentas;
	private ServicioDivisas servicioDivisas;
	
	public void setGestorCuentas(GestorCuentas gestorCuentas){
		this.gestorCuentas = gestorCuentas;
	}
	
	public void setServicioDivisas(ServicioDivisas servicioDivisas){
		this.servicioDivisas = servicioDivisas;
	}
	
	public Cuenta abrirCuenta(String titular, double saldoInicial, Divisa divisa){
		Cuenta cuenta = new Cuenta(titular, saldoInicial, divisa);
		gestorCuentas.alta(cuenta);
		
		return cuenta;
	}
	
	public Cuenta abrirCuenta(String titular, double saldoInicial){
		Cuenta cuenta = new Cuenta(titular, saldoInicial);
		gestorCuentas.alta(cuenta);
		
		return cuenta;
	}
	
	public Cuenta abrirCuenta(String titular){
		Cuenta cuenta = new Cuenta(titular);
		gestorCuentas.alta(cuenta);
		
		return cuenta;
	}
	
	public Cuenta getCuenta(String titular){
		Cuenta cuenta = gestorCuentas.getCuenta(titular);
		
		if (cuenta == null)
			throw new OperativaCuentaException("El usuario no existe");
		
		return cuenta;
	}
	
	/** Actualiza la cuenta con los intereses generados.
	 *  
	 * @return devuelve los intereses que se han generado.
	 */
	public double setIntereses(String titular){
		Cuenta cuenta = getCuenta(titular);
		
		double intereses = cuenta.getSaldo() * RATIO_INTERES;
		cuenta.ingresar(intereses);
		gestorCuentas.salvar(cuenta);
		
		return intereses;
	}
	
	public void transferencia(String titularOrigen, String titularDestino, double cantidad){
		Cuenta ctaOrigen = getCuenta(titularOrigen);
		Cuenta ctaDestino = getCuenta(titularDestino);
		
		double cantidadTransferir = 0;
		
		if (ctaOrigen.getDivisa() == ctaDestino.getDivisa()){
			cantidadTransferir = cantidad;
		}
		else{
			//Transferencia entre cuentas de distinta divisa
			cantidadTransferir = servicioDivisas.convertir(ctaOrigen.getDivisa(), ctaDestino.getDivisa(), cantidad);
		}
		
		ctaOrigen.sacar(cantidad);
		ctaDestino.ingresar(cantidadTransferir);
		gestorCuentas.salvar(ctaOrigen);
		gestorCuentas.salvar(ctaDestino);
	}

}
