package ar.edu.unlam.tallerweb2.clase20120915

class CuentaCorriente extends Cuenta {
	def descubierto = -1000
	def cantMaxMovimientosSC   = 5
	def precioMultaMovimientos = 2
	
	@Override
	void importeValido(double importe){
		if (importe <= 0){
			throw new ImporteIncorrectoException('Importe a extraer incorrecto.')
		}
	}
	
	double multaMovimientos(def movimiento){
		double suma = 0
		 
		if (movimiento > cantMaxMovimientosSC)
			 	suma = precioMultaMovimientos
		
		suma
			 
		}
	@Override
	void restaSaldo(double importe){
		def saldoParcial = saldo - importe
		
		if(saldoParcial < descubierto){
			throw new SaldoInsuficienteException('Saldo Insuficiente')
			}		 
		else{
			saldo = saldoParcial
			cantidadMovimientos++
		}
		 
		}
	
	@Override
	double extraer(double importe) {
		def movimientoActual = cantidadMovimientos + 1
		
		importeValido(importe)

		importe = importe + multaMovimientos(movimientoActual)
		
		restaSaldo(importe)
		
		saldo

	}
}
