package ar.edu.unlam.tallerweb2.clase20120915

import org.junit.Before
import org.junit.Test


class CuentaCorrienteTest {
	CuentaCorriente cuentaCorriente
	Cliente 		cliente
	
	@Before
	void setUp(){
	cliente = new Cliente(nombre:'Sergio')
    cuentaCorriente = new CuentaCorriente(saldo:3000, cliente:cliente, cantidadMovimientos:0)	
		}

	
	@Test
	void crearCuentaCorrienteTest(){
	
	assert cuentaCorriente.saldo == 3000
	assert cuentaCorriente.cantidadMovimientos == 0
	assert cuentaCorriente.cliente.nombre == 'Sergio'
	
	}
	
	@Test(expected = ImporteIncorrectoException)
	void extraerImporteIncorrectoCuentaCorrienteTest(){
		
		cuentaCorriente.extraer(-1)
		
		assert cuentaCorriente.saldo == 2992
	}
	
	@Test
	void extraerCorrectamenteCuentaCorrienteTest(){
	cuentaCorriente.extraer(4000)	
		
	assert cuentaCorriente.saldo == -1000

	}

	@Test(expected = SaldoInsuficienteException)
	void extraerMenorDescubiertoCuentaCorrienteTest(){
	cuentaCorriente.extraer(4050)
		
	assert cuentaCorriente.saldo == -1050

	}

		
	@Test
	void extraerLimiteSinCargoCuentaCorrienteTest(){
	def x = 0
	
	while (x < 5){
    cuentaCorriente.extraer(1)	
	x++
	}
	
	assert cuentaCorriente.saldo == 2995
	
	}

	@Test	
	void extraerConCargoCuentaCorrienteTest(){	
		def x = 0
		
		while (x < 6){
		cuentaCorriente.extraer(1)
		x++
		}
		
		assert cuentaCorriente.saldo == 2992
	}
	
}
