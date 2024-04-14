package juego.geometria;

/**
 * Clase Circulo
 * @author Alumno
 *
 */
public class circulo {
    /**
     * Constante default
     */
    public static int default_radio = 5;
    
    /**
     * Atributo privado Punto de Circulo
     */
    private Punto centro;
    
    /**
     * Atributo privado radio de Circulo
     */
    private int radio;
    
    /**
     * Constructor del circulo pasando como parametros un punto como centro y un radio
     * @param centroIni
     * @param radioIni
     */
    public circulo(Punto centroIni, int radioIni){
        centro = centroIni;
        radio = radioIni;
    }
    
    /**
     * Constructor de circulo por defecto
     */
    public circulo(){
        this(new Punto(), default_radio);
    }
    
    /**
     * Método para obtener el punto del centro del circulo
     * @return
     */
    public Punto getCentro() {
        return this.centro;
    }
    
    /**
     * Método para obtener el radio del circulo
     * @return
     */
    public int getRadio() {
        return this.radio;
    }
    
    /**
     * Método para modificar el centro del circulo
     * @param centro
     */
    public void setCentro(Punto centro){
        this.centro = centro;
    }
    
    /**
     * Método para modificar el radio del circulo
     * @param radio
     */
    public void setRadio(int radio){
        this.radio = radio;
    }
    
    /**
     * Método para obteneter el perimetro del circulo
     * @return
     */
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    /**
     * Método para desplazar el circulo
     * @param incX
     * @param incY
     */
    public void desplazar(int incX, int incY){
        centro = centro.desplazar(incX, incY);
    }
    
    /**
     * Método para escalar el circulo
     * @param porcentaje
     */
    public void escalar(double porcentaje){
        radio = (int)(radio * (porcentaje/100));
    }
}
