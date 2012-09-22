package ar.edu.unlam.tallerweb2.clase20120915

import org.junit.Before;
import org.junit.Test;

class CajaAhorroTest {
	CajaAhorro  cajaAhorro1
	CajaAhorro  cajaAhorro2
	Cliente     cliente1
	Cliente     cliente2
	
	@Before
	void setUp(){
	cliente1 = new Cliente(nombre:'Yanet')
	cajaAhorro1 = new CajaAhorro(saldo:3000, cliente:cliente1, cantidadMovimientos:0)
	
	cliente2 = new Cliente(nombre:'Sergio')
	cajaAhorro2 = new CajaAhorro(saldo:500, cliente:cliente2, cantidadMovimientos:0)
		}
	
	@Test
	void crearCajaAhorroTest(){
	
	assert cajaAhorro1.saldo == 3000
	assert cajaAhorro1.cantidadMovimientos == 0
	assert cajaAhorro1.cliente.nombre == 'Yanet'
	
	}
	
	@Test(expected = ImporteIncorrectoException)
	void extraerImporteIncorrectoCuentaCorrienteTest(){
		
		cajaAhorro1.extraer(-1)
		
		assert cajaAhorro1.saldo == 2992
	}
	
	@Test
	void extraerMenorDiarioCajaAhorroTest(){
			cajaAhorro1.extraer(500)
			assert cajaAhorro1.saldo == 2500

	}

	@Test
	void extraerLimiteDiarioCajaAhorroTest(){
				cajaAhorro1.extraer(1000)
				assert cajaAhorro1.saldo == 2000
	}
	
	@Test(expected = ImporteIncorrectoException)
	void extraerSuperiorDiarioCajaAhorroTest(){
				cajaAhorro1.extraer(1200)
				assert cajaAhorro1.saldo == 1800
	
	}

	@Test(expected = SaldoInsuficienteException)
	void extraerSuperiorSaldoCajaAhorroTest(){
				cajaAhorro2.extraer(600)
		
				assert cajaAhorro2.saldo == -100

	}
	
}
