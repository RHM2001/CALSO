package operativa.cuentas;

public interface ServicioDivisas {
	/**
	 * Devuelve la cantidad pasada como parámetro en la divisa "from" a la cantidad
	 * correspondiente en la divisa "to"
	 * @param from Divisa origen del cambio
	 * @param to Divisa a la que se va a hacer el cambio
	 * @param cantidad cantidad que se va a convertir
	 * @return cantidad en la divisa destino
	 */
	double convertir (Divisa from, Divisa to, double cantidad);

}
