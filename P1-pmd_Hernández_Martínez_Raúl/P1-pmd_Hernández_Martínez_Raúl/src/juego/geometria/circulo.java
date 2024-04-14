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
     * M�todo para obtener el punto del centro del circulo
     * @return
     */
    public Punto getCentro() {
        return this.centro;
    }
    
    /**
     * M�todo para obtener el radio del circulo
     * @return
     */
    public int getRadio() {
        return this.radio;
    }
    
    /**
     * M�todo para modificar el centro del circulo
     * @param centro
     */
    public void setCentro(Punto centro){
        this.centro = centro;
    }
    
    /**
     * M�todo para modificar el radio del circulo
     * @param radio
     */
    public void setRadio(int radio){
        this.radio = radio;
    }
    
    /**
     * M�todo para obteneter el perimetro del circulo
     * @return
     */
    public double getPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    /**
     * M�todo para desplazar el circulo
     * @param incX
     * @param incY
     */
    public void desplazar(int incX, int incY){
        centro = centro.desplazar(incX, incY);
    }
    
    /**
     * M�todo para escalar el circulo
     * @param porcentaje
     */
    public void escalar(double porcentaje){
        radio = (int)(radio * (porcentaje/100));
    }
}
