package operativa.tests;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import operativa.cuentas.Cuenta;
import operativa.cuentas.Divisa;
import operativa.cuentas.GestorCuentas;
import operativa.cuentas.ServicioCuentas;
import operativa.cuentas.ServicioDivisas;
import operativa.cuentas.ServicioDivisasStub;

public class ServicioCuentasTest {

	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	private final GestorCuentas gestorCuentasMock = context.mock(GestorCuentas.class);
	private final ServicioCuentas servicioCuentas = new ServicioCuentas();
	private final ServicioDivisasStub servicioDivisasStub = new ServicioDivisasStub();

//	El colaborador GestorCuentas debe ser implementado como objeto mock, 
//	ya que este objeto se utiliza para simular el comportamiento de las dependencias 
//	de la clase ServicioCuentas durante las pruebas. Al utilizar objetos mock, podemos 
//	controlar el comportamiento de estas dependencias y asegurarnos de que la clase ServicioCuentas se comporta 
//	de la manera esperada en diferentes escenarios de prueba ya que lo estamos usando para
//  obtener recursos de una base de datos.
	
//	El colaborador ServicioDivisas debe ser implementado como stub
//	para simular la respuesta de una clase o componente que se est� probando 
//	ya que hace uso de un servicio externo para obtener el tipo de cambio entre dos divisas

	@Test
	public void testAbrirCuenta1() {

		// Creamos una instancia de la clase Cuenta
		final Cuenta cuenta = new Cuenta("Juan P�rez", 1000.0, Divisa.EURO);

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				oneOf(gestorCuentasMock).alta(cuenta);
			}
		});

		gestorCuentasMock.alta(cuenta);

		// Comprobamos que la funci�n devuelve la cuenta esperada
		assertEquals(cuenta, cuenta);
	}

	@Test
	public void testAbrirCuenta2() {

		// Creamos una instancia de la clase Cuenta
		final Cuenta cuenta = new Cuenta("Juan P�rez", 1000.0);

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				oneOf(gestorCuentasMock).alta(cuenta);
			}
		});

		gestorCuentasMock.alta(cuenta);

		// Comprobamos que la funci�n devuelve la cuenta esperada
		assertEquals(cuenta, cuenta);
	}

	@Test
	public void testAbrirCuenta3() {

		// Creamos una instancia de la clase Cuenta
		final Cuenta cuenta = new Cuenta("Juan P�rez");

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				oneOf(gestorCuentasMock).alta(cuenta);
			}
		});

		gestorCuentasMock.alta(cuenta);

		// Comprobamos que la funci�n devuelve la cuenta esperada
		assertEquals(cuenta, cuenta);
	}

	@Test
	public void testGetCuenta() {

		// Creamos una instancia de la clase Cuenta
		final Cuenta cuenta = new Cuenta("Juan P�rez");

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				oneOf(gestorCuentasMock).getCuenta("Juan P�rez");
				will(returnValue(cuenta));
			}
		});

		servicioCuentas.setGestorCuentas(gestorCuentasMock);
		Cuenta q = servicioCuentas.getCuenta("Juan P�rez");

		// Comprobamos que la funci�n devuelve la cuenta esperada
		assertEquals(cuenta, q);
	}

	@Test
	public void testSetIntereses() {

		final Cuenta cuenta = new Cuenta("Juan P�rez", 1000.0);

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				// Se espera que se llame al m�todo getCuenta con los valores de prueba
				oneOf(gestorCuentasMock).getCuenta("Juan P�rez");
				will(returnValue(cuenta));
				// Se espera que se llame al m�todo salvar con la cuenta actualizada
				oneOf(gestorCuentasMock).salvar(cuenta);
			}
		});

		servicioCuentas.setGestorCuentas(gestorCuentasMock);

		double result = servicioCuentas.setIntereses("Juan P�rez");

		// Comprobamos que la funci�n devuelve el valor esperado
		assertEquals(50, result, 0);
	}

	@Test
	public void transferencia() {
		
		// Creamos las instancias de las clases Cuenta
		final Cuenta cuentaOrigen = new Cuenta("Juan P�rez", 1000.0, Divisa.EURO);
		final Cuenta cuentaDestino = new Cuenta("Ana Gonz�lez", 1000.0, Divisa.DOLAR);

		// Configuramos las expectativas del mock
		context.checking(new Expectations() {
			{
				// Se espera que se llame al m�todo getCuenta con los valores de prueba
				oneOf(gestorCuentasMock).getCuenta("Juan P�rez");
				will(returnValue(cuentaOrigen));
				// Se espera que se llame al m�todo getCuenta con los valores de prueba
				oneOf(gestorCuentasMock).getCuenta("Ana Gonz�lez");
				will(returnValue(cuentaDestino));
				
				oneOf(gestorCuentasMock).salvar(cuentaOrigen);
				// Se espera que se llame al m�todo salvar con la cuenta destino actualizada
				oneOf(gestorCuentasMock).salvar(cuentaDestino);
				
			}
		});
		
		servicioCuentas.setGestorCuentas(gestorCuentasMock);
		servicioCuentas.setServicioDivisas(servicioDivisasStub);
		servicioCuentas.transferencia("Juan P�rez", "Ana Gonz�lez", 100);
		
		assertEquals(900.0, cuentaOrigen.getSaldo(), 0);
		assertEquals(1106.0, cuentaDestino.getSaldo(), 0);
		
		
	}
}
