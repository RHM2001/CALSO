package operativa.cuentas;

public class OperativaCuentaException extends RuntimeException {

	public OperativaCuentaException(){
		super();
	}
	
	public OperativaCuentaException(String mensaje){
		super(mensaje);
	}
	
}
