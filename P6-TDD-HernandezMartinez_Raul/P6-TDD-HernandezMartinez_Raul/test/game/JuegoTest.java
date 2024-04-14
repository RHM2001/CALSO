package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	/*
	 * Este test falla siempre. Debe eliminarse e incorporarse, de forma ordenada los test que se vayan diseñando desde los
	 * requisitos propuestos.
	 */
//	@Test
//	public void testJugar() {
//		fail("Not yet implemented");
//	}
	
	int [] sinAmenaza1 = {2, 1, 1, 3};
	int [] sinAmenaza2 = {3, 2, 3, 4};
	
	Juego j = new Juego(sinAmenaza1, sinAmenaza2);
	
	@Test
	public void testPosicionEnTablero11(){
		assertTrue(j.comprobarPosicion(1,1));
	}
	
	@Test
	public void testPosicionEnTablero01(){
		assertFalse(j.comprobarPosicion(0,1));
	}
	
	@Test
	public void testPosicionEnTablero41(){
		assertTrue(j.comprobarPosicion(4,1));
	}
	
	@Test
	public void testPosicionEnTablero51(){
		assertFalse(j.comprobarPosicion(5,1));
	}
	
	@Test
	public void testPosicionNoEnTablero00(){
		assertFalse(j.comprobarPosicion(0,0));
	}
	
	@Test
	public void testPosicionEnTablero10(){
		assertFalse(j.comprobarPosicion(1,0));
	}
	
	@Test
	public void testPosicionEnTablero14(){
		assertTrue(j.comprobarPosicion(1,4));
	}
	
	@Test
	public void testPosicionEnTablero15(){
		assertFalse(j.comprobarPosicion(1,5));
	}
	
	@Test(expected = Exception.class)
	public void testJugar00(){
		j.jugar(0,0);
	}
	
	@Test(expected = Exception.class)
	public void testJugar10(){
		j.jugar(1,0);
	}
	
	@Test
	public void testJugar14(){
		j.jugar(1,4);
	}
	
	@Test(expected = Exception.class)
	public void testJugar15(){
		j.jugar(1,5);
	}
	
	@Test
	public void testJugar11(){
		j.jugar(1,1);
	}
	
	@Test(expected = Exception.class)
	public void testJugar01(){
		j.jugar(0,1);
	}
	
	@Test
	public void testJugar41(){
		j.jugar(4,1);
	}
	
	@Test(expected = Exception.class)
	public void testJugar51(){
		j.jugar(5,1);
	}
	
	@Test
	public void testSiguienteJugador1To2(){
		j.siguienteJugador();
		assertEquals(2.0, j.getJugadorEnJuego(), 0);
	}
	
	@Test
	public void testSiguienteJugador2To1(){
		j.siguienteJugador();
		j.siguienteJugador();
		assertEquals(1.0, j.getJugadorEnJuego(), 0);
	}
	
	@Test
	public void testSinAmenaza(){
		assertFalse(j.determinarAmenaza());
	}
	
	@Test
	public void testAmenazaFila(){
		int [] amenazaFila1 = {1, 1, 1, 2};
		int [] amenazaFila2 = {1, 3, 1, 4};
		Juego x = new Juego(amenazaFila1, amenazaFila2);
		assertTrue(x.determinarAmenaza());
	}
	
	@Test
	public void testAmenazaColumna(){
		int [] amenazaColumna1 = {1, 1, 2, 1};
		int [] amenazaColumna2 = {3, 1, 4, 1};
		Juego x = new Juego(amenazaColumna1, amenazaColumna2);
		assertTrue(x.determinarAmenaza());
	}
	
	@Test
	public void testComprobarPosicionEnTableroZonaLibre() {
		assertTrue(j.comprobarPosicion(1,1));
	}
	
	@Test
	public void testComprobarPosicionEnTableroZonaNoLibreJ1T1() {
		assertFalse(j.comprobarPosicion(2,1));
	}
	
	@Test
	public void testComprobarPosicionEnTableroZonaNoLibreJ1T2() {
		assertFalse(j.comprobarPosicion(1,3));
	}
	
	@Test
	public void testComprobarPosicionEnTableroZonaNoLibreJ2T1() {
		assertFalse(j.comprobarPosicion(3,2));
	}
	
	@Test
	public void testComprobarPosicionEnTableroZonaNoLibreJ2T2() {
		assertFalse(j.comprobarPosicion(3,4));
	}
	
	@Test(expected = Exception.class)
	public void testJugar21(){
		j.jugar(2,1);
	}
	
	@Test(expected = Exception.class)
	public void testJugar13(){
		j.jugar(1,3);
	}
	
	@Test(expected = Exception.class)
	public void testJugar32(){
		j.jugar(3,2);
	}
	
	@Test(expected = Exception.class)
	public void testJugar34(){
		j.jugar(3,4);
	}
	
	@Test
	public void testJugar12(){
		j.jugar(1,2);
	}
	
	
	
	

}
