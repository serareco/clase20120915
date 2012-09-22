package ar.edu.unlam.tallerweb2.clase20120915

abstract class Cuenta {
	
	double  saldo
	def     cantidadMovimientos
	Cliente cliente
	
	abstract double extraer(double importe);
	
	abstract void importeValido(double importe);
	
	abstract void restaSaldo(double importe);
}
