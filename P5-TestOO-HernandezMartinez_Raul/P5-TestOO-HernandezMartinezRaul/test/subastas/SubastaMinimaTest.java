package subastas;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubastaMinimaTest extends SubastaTest{
	
		Usuario propietario = new Usuario("Pedro", 120);
		
		SubastaMinima subasta = new SubastaMinima(propietario, "coche", 30);

	@Test
	public void testEjecutarNoCantidadMinima() {
		Usuario pujador = new Usuario("Antonio", 100);
		subasta.pujar(pujador, 10);
		assertFalse(subasta.ejecutar());
	}
	
	@Test
	public void testCerrarSubastaAbierta() {
		subasta.cerrar();
		assertFalse(subasta.isAbierta());
	}
	
	@Test(expected = Exception.class)
	public void testCerrarSubastaCerrada() {
		subasta.setAbierta(false);
		subasta.cerrar();
	}
	

}
