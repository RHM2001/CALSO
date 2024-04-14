package game;


/*
 * Clase Juego tiene la responsabilidad de ofrecer las funcionalidades básicas del juego de tablero descrito en
 * el enunciado de la práctica. Inicialmente no se implementa funcionalidad alguna y el estado de la programación de la clase es inicial
 * No se recogen ni estructras de datos ni métodos que deberán incorprarse de forma progresiva.
 * 
 * IMPORTANTE: recordad el ciclo TDD: Test->Código->Refactorización->Test->...
 */

public class Juego {
	
	private int jugadorEnJuego;
	private int [] torresJugador1;
	private int [] torresJugador2;
	
	public Juego(int [] torresJugador1, int [] torresJugador2) {
		jugadorEnJuego = 1;
		this.torresJugador1 = torresJugador1;
		this.torresJugador2 = torresJugador2;
	}
	
	/*
	 * Método de inicio asociado al requisito 1 donde se implementa la funcionalidad básica de posicionar una pieza en el tablero.
	 * 
	 * @param x fila de la casilla en la que se desea incorporar la pieza
	 * @param y columna de la casilla en la que se desea indorporar la pieza 
	 */
	public void jugar(int x, int y) {
		if(comprobarPosicion(x,y) == false) {
			throw new RuntimeException("Posición invalida");
		}
	}
	
	public void siguienteJugador() {
		if(jugadorEnJuego == 1) {
			jugadorEnJuego = 2;
		}
		else {
			jugadorEnJuego = 1;
		}
	}
	
	public boolean comprobarPosicion(int x, int y){
		if(x < 1 || x > 4 || y < 1 || y > 4){
			return false;
		}
		
		if(x == torresJugador1[0] && y == torresJugador1[1]) {
			return false;
		}
		
		if(x == torresJugador1[2] && y == torresJugador1[3]) {
			return false;
		}
		
		if(x == torresJugador2[0] && y == torresJugador2[1]) {
			return false;
		}
		
		if(x == torresJugador2[2] && y == torresJugador2[3]) {
			return false;
		}
		
		return true;
	}
	
	public boolean determinarAmenaza() {
		if(torresJugador1[0] == torresJugador2[0] || torresJugador1[0] == torresJugador2[2]
				|| torresJugador1[2] == torresJugador2[0] || torresJugador1[2] == torresJugador2[2]) {
			return true;
		}
		
		if(torresJugador1[1] == torresJugador2[1] || torresJugador1[1] == torresJugador2[3]
				|| torresJugador1[3] == torresJugador2[1] || torresJugador1[3] == torresJugador2[3]) {
			return true;
		}
		
		return false;
	}
	
	public int getJugadorEnJuego() {
		return jugadorEnJuego;
	}

	public void setJugadorEnJuego(int jugadorEnJuego) {
		this.jugadorEnJuego = jugadorEnJuego;
	}
	
	

}
