package operativa.cuentas;

public class ServicioDivisasStub implements ServicioDivisas{

	public double convertir (Divisa from, Divisa to, double cantidad) {
		double conversion = cantidad;
		
		//Solo hago la conversión de EURO a DOLAR
		
		if(from == Divisa.EURO && to == Divisa.DOLAR) {
			conversion = cantidad * 1.06;
		}
		
		return conversion;
	}
}
