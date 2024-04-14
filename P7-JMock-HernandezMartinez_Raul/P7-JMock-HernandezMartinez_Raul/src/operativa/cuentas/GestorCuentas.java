package operativa.cuentas;

/** Accede a la base de datos (vía JDBC) para recuperar y actualizar
 *  la información relativa a las cuentas
 * 
 */
public interface GestorCuentas {
	/** Recupera la cuenta cuyo titular es el que se pasa como parámetro.
	 * 
	 * @param titular identificador del titular de la cuenta
	 * @return devuelve la cuenta asociada al titular o null si no se ha encontrado
	 */
	Cuenta getCuenta(String titular);
	
	/** Actualiza la cuenta en la base de datos.
	 * 
	 * @param cuenta cuenta que se va guardar/actualizar.
	 */
	void salvar(Cuenta cuenta);
	
	/**
	 * Registra la nueva cuenta en la base de datos asociada al titular
	 * @param cuenta cuenta que acaba de abrir
	 */
	void alta(Cuenta cuenta);
}
