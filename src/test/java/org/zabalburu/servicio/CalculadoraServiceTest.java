package org.zabalburu.servicio;
/* hay que introducir este import para reconocer las aserciones */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*Esto hay que pone, sale de la librerias de springBoot */

@SpringBootTest
public class CalculadoraServiceTest {
	/*Esto es para inyectar un objeto de calculadora servicio */
	@Autowired
	CalculadoraService servicio;
	
	/* Para indicarle que es un test se pone @test*/
	@Test
	public void testSuma() {
		double resultado = servicio.suma(5, 5);
		assertEquals(10, resultado);
	}
	
	@Test
	public void testDivision() {
		double resultado = servicio.division(5, 2);
		assertEquals(2.5, resultado);
	}
	
	@Test
	public void testDivisionEntreCero() {
		double resultado = servicio.division(5, 0);
		assertEquals(Double.POSITIVE_INFINITY, resultado);
	}
	
}
