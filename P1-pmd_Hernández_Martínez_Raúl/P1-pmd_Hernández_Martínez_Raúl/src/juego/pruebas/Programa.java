package juego.pruebas;

import juego.geometria.Punto;

/**
 * Clase programa para hacer pruebas
 * @author Alumno
 *
 */
public class Programa {

    /**
     * Main del programa
     * @param args
     */
    public static void main(String args[]) {
      Punto punto1 = new Punto();

      Punto puntos[] = new Punto[2]; 
      puntos[0] = punto1;
      
      String info = ""; 

      for (Punto punto : puntos)
          info.concat(punto.toString()); // NOPMD by Raúl Hernández Martínez on 26/09/22 19:12 - Ley Demeter

     String mensaje = "".equals(info) ? "no hay puntos" : info; 

     System.out.println(mensaje); // NOPMD by Raúl Hernández Martínez on 26/09/22 19:12 - Muestra un mensaje por la consola
    }
}
