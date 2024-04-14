package operativa.cuentas;

public class Cuenta {
	private final static Divisa DEFAULT_DIVISA = Divisa.EURO;
	private final static double DEFAULT_SALDO = 100d;
	private static int nextNumeroCuenta = 1;
	
	private int numeroCuenta;
	private String titular;
	private double saldo;
	private Divisa divisa;
	
	public Cuenta(String titular){
		this(titular, DEFAULT_SALDO, DEFAULT_DIVISA);
	}
	
	public Cuenta(String titular, double saldo){
		this(titular, saldo, DEFAULT_DIVISA);
	}
	
	public Cuenta(String titular, double saldo, Divisa divisa){
		this.numeroCuenta = nextNumeroCuenta++;
		this.titular = titular;
		this.saldo = saldo;
		this.divisa = divisa;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Divisa getDivisa() {
		return divisa;
	}
	
	public void ingresar(double cantidad){
		saldo += cantidad;
	}
	
	public void sacar(double cantidad){
		//La cuenta puede quedar al descubierto
		saldo -= cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisa == null) ? 0 : divisa.hashCode());
		result = prime * result + numeroCuenta;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (divisa != other.divisa)
			return false;
		if (numeroCuenta != other.numeroCuenta)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}
	
	
}
