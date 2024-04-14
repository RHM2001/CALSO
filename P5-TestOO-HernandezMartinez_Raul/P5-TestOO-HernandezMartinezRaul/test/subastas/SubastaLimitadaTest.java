package subastas;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubastaLimitadaTest extends SubastaTest{

	Usuario propietario = new Usuario("Pedro", 120);
	
	SubastaLimitada subasta = new SubastaLimitada(propietario, "coche", 4);
	
	@Test
	public void testPujarSinSuperarLimite() {
		Usuario pujador1 = new Usuario("Antonio", 100);
		Usuario pujador2 = new Usuario("Juan", 90);
		Usuario pujador3 = new Usuario("Luis", 120);
		Usuario pujador4 = new Usuario("Alex", 175);
		subasta.pujar(pujador1, 10);
		subasta.pujar(pujador2, 20);
		subasta.pujar(pujador3, 30);
		assertTrue(subasta.pujar(pujador4, 40));
	}
	
	@Test
	public void testPujarSuperarLimite() {
		Usuario pujador1 = new Usuario("Antonio", 100);
		Usuario pujador2 = new Usuario("Juan", 90);
		Usuario pujador3 = new Usuario("Luis", 120);
		Usuario pujador4 = new Usuario("Alex", 175);
		Usuario pujador5 = new Usuario("Ana", 150);
		subasta.pujar(pujador1, 10);
		subasta.pujar(pujador2, 20);
		subasta.pujar(pujador3, 30);
		subasta.pujar(pujador4, 40);
		assertFalse(subasta.pujar(pujador5, 50));
	}
	
}
