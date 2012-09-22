package ar.edu.unlam.tallerweb2.clase20120915

class CajaAhorro extends Cuenta {
	
	def valorMaxExtraccion = 1000

@Override
	void importeValido(double importe){
		if (importe <= 0 || importe > valorMaxExtraccion){
			throw new ImporteIncorrectoException('Importe a extraer incorrecto.')
		}
	}

@Override
void restaSaldo(double importe){
	def saldoParcial = saldo - importe
	
	if(saldoParcial < 0){
		throw new SaldoInsuficienteException('Saldo Insuficiente')
		}
	else{
		saldo = saldoParcial
		cantidadMovimientos++
	}
	 
	}
@Override
	double extraer(double importe) {
		
		importeValido(importe)
		
		restaSaldo(importe)
		
		saldo
	}

}
