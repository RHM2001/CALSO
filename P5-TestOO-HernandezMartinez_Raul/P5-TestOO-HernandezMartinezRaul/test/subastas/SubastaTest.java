package subastas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubastaTest {
	
	Usuario propietario;
	Subasta subasta;
//	SubastaMinima subasta;
//	SubastaLimitada subasta;
		
	@Before
	public void setUp(){
		propietario = new Usuario("Pedro", 120);
		//Clase subasta padre
		subasta = new Subasta(propietario, "coche");
//		subasta = new SubastaMinima(propietario, "coche", 30);
//		subasta = new SubastaLimitada(propietario, "coche", 4);
	}
	
	//Prueba de métodos
	
	@Test(expected = Exception.class)
	public void testPujaNoAbierta1() {
		Usuario pujador = new Usuario("Antonio", 50);
		subasta.setAbierta(false);
		subasta.pujar(pujador, 20);
	}
	
	@Test
	public void testUsuarioEsPropietarioPuja1() {
		assertFalse(subasta.pujar(propietario, 50));
	}
	
	@Test
	public void testCreditoMenorCantidad() {
		Usuario pujador1 = new Usuario("Antonio", 200);
		Usuario pujador2 = new Usuario("Juan", 300);
		subasta.pujar(pujador1, 50);
		assertFalse(subasta.pujar(pujador2, 20));
	}
	
	@Test
	public void testPujaCorrecta1() {
		Usuario pujador1 = new Usuario("Antonio", 200);
		Usuario pujador2 = new Usuario("Juan", 300);
		subasta.pujar(pujador1, 50);
		assertTrue(subasta.pujar(pujador2, 60));
	}
	
	@Test(expected = Exception.class)
	public void testPujaNoAbierta2() {
		Usuario pujador = new Usuario("Antonio");
		subasta.setAbierta(false);
		subasta.pujar(pujador);
	}
	
	@Test
	public void testUsuarioEsPropietarioPuja2() {
		assertFalse(subasta.pujar(propietario));
	}
	
	@Test
	public void testPujaCorrecta2() {
		Usuario pujador1 = new Usuario("Antonio", 200);
		Usuario pujador2 = new Usuario("Juan", 300);
		subasta.pujar(pujador1);
		assertTrue(subasta.pujar(pujador2));
	}
	
	@Test(expected = Exception.class)
	public void testEjecutarPujaNoAbierta() {
		Usuario pujador = new Usuario("Antonio", 200);
		subasta.pujar(pujador, 30);
		subasta.setAbierta(false);
		subasta.ejecutar();
	}
	
	@Test
	public void testEjecutarSinPuja() {
		assertFalse(subasta.ejecutar());
	}
	
	@Test
	public void testEjecutarCorrectamente() {
		Usuario pujador = new Usuario("Antonio", 50);
		subasta.pujar(pujador, 30);
		assertTrue(subasta.ejecutar());
	}
	
	//Pruebas de clase aleatorias
	
	@Test
	public void testCuatroPujasCantidadEjecutar() {
		Usuario propietario = new Usuario("Felix", 120);
		Subasta subasta = new Subasta(propietario, "Videoconsola");
		Usuario propietario1 = new Usuario("Sergio", 100);
		Usuario propietario2 = new Usuario("Begoña", 200);
		Usuario propietario3 = new Usuario("Leo", 75);
		Usuario propietario4 = new Usuario("Lucia", 80);
		subasta.pujar(propietario1, 20);
		subasta.pujar(propietario2, 25);
		subasta.pujar(propietario3, 27);
		subasta.pujar(propietario4, 30);
		assertTrue(subasta.ejecutar());
	}
	
	@Test
	public void testDosPujasDiferentesEjecutar() {
		Usuario propietario = new Usuario("Felix", 120);
		Subasta subasta = new Subasta(propietario, "Videoconsola");
		Usuario propietario1 = new Usuario("Sergio", 100);
		Usuario propietario2 = new Usuario("Begoña", 200);
		subasta.pujar(propietario1, 20);
		subasta.pujar(propietario2);
		assertTrue(subasta.ejecutar());
	}
	
	@Test
	public void testCuatroPujasSinCantidadEjecutar() {
		Usuario propietario = new Usuario("Felix", 120);
		Subasta subasta = new Subasta(propietario, "Videoconsola");
		Usuario propietario1 = new Usuario("Sergio", 100);
		Usuario propietario2 = new Usuario("Begoña", 200);
		Usuario propietario3 = new Usuario("Leo", 75);
		Usuario propietario4 = new Usuario("Lucia", 80);
		subasta.pujar(propietario1);
		subasta.pujar(propietario2);
		subasta.pujar(propietario3);
		subasta.pujar(propietario4);
		assertTrue(subasta.ejecutar());
	}
	
	@Test
	public void testDosPujasDiferentesSinEjecutar() {
		Usuario propietario = new Usuario("Felix", 120);
		Subasta subasta = new Subasta(propietario, "Videoconsola");
		Usuario propietario1 = new Usuario("Sergio", 100);
		Usuario propietario2 = new Usuario("Begoña", 200);
		subasta.pujar(propietario1, 20);
		assertTrue(subasta.pujar(propietario2));
	}
}
