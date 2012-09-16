package ar.edu.unlam.tallerweb2.clase20120915

abstract class Cuenta {
	
	double saldo
	int cantidadMovimientos
	Cliente cliente
	
	public abstract double extraer(double importe);

}
