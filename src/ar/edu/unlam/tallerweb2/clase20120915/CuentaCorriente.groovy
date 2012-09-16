package ar.edu.unlam.tallerweb2.clase20120915

class CuentaCorriente extends Cuenta {
	

	@Override
	double extraer(double importe) {
		if(importe<=0){
			throw new ImporteNegativoException('El importe a extraer debe ser positivo.')
		}

		double saldoParcial = saldo
		if(cantidadMovimientos + 1 > 5){
			importe +=2
		}

		saldoParcial -= importe
		if(saldoParcial>-1000){
			saldo = saldoParcial
			cantidadMovimientos++
		}else{
			throw new SaldoInsuficienteException('El saldo actual $'+saldo+' no le permite realizar la extracción.')
		}
		saldo
	}
}
