package maquinacafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CafeteraTest {
	
	Cafetera cafetera;
	
	@Before
	public void setUp() throws Exception {
		cafetera = new Cafetera();
	}
	
	
	@Test
	public void testAddRecetaNull() {
		Receta receta = null;
		assertFalse(cafetera.addReceta(receta));
	}

	@Test
	public void testAddRecetaNoCoincide() {
		Receta receta = new Receta("Solo", 20, 3, 0, 1, 0);
		assertTrue(cafetera.addReceta(receta));
	}
	
	@Test
	public void testAddRecetaCoincide() {
		Receta receta = new Receta("Solo", 20, 3, 0, 1, 0);
		cafetera.addReceta(receta);
		assertFalse(cafetera.addReceta(receta));
	}
	
	@Test
	public void testAddRecetaSuperaMax() {
		Receta receta1 = new Receta("Solo", 20, 3, 0, 1, 0);
		cafetera.addReceta(receta1);
		Receta receta2 = new Receta("Leche", 20, 0, 3, 1, 0);
		assertFalse(cafetera.addReceta(receta2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditarRecetaNull() {
		Receta receta = null;
		cafetera.editarReceta(null, receta);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditarRecetaNoCoincideNombre() {
		Receta receta = new Receta("Solo", 20, 3, 0, 1, 0);
		cafetera.editarReceta("manchado", receta);
	}
	
	@Test
	public void testEditarRecetaOk() {
		Receta receta1 = new Receta("Solo", 3, 20, 0, 1, 0);
		cafetera.addReceta(receta1);
		Receta receta2 = new Receta("Solo", 1, 15, 3, 1, 4);
		assertNotNull(cafetera.editarReceta("Solo", receta2));
	}
	
	@Test
	public void testHacerCafeNoRecetario() {
		assertEquals(2, cafetera.hacerCafe("Solo", 2), 0);
	}
	
	@Test
	public void testHacerCafeSuficienteDinero() {
		Receta receta = new Receta("Solo", 3, 20, 0, 1, 0);
		cafetera.addReceta(receta);
		assertEquals(1, cafetera.hacerCafe("Solo", 1), 0);
	}
	
	@Test
	public void testHacerCafeNoSuficienteIngredientes() {
		Receta receta = new Receta("Solo", 1, 500, 1, 1, 1);
		cafetera.addReceta(receta);
		Inventario inventario = new InventarioStub();
		cafetera.setInventario(inventario);
		assertEquals(4, cafetera.hacerCafe("Solo", 4), 0);
	}
	
	@Test
	public void testHacerCafeSuficienteIngredientes() {
		Receta receta = new Receta("Solo", 1, 1, 1, 1, 1);
		cafetera.addReceta(receta);
		Inventario inventario = new InventarioStub();
		cafetera.setInventario(inventario);
		assertEquals(3, cafetera.hacerCafe("Solo", 4), 0);
	}
	
	
	
	

}