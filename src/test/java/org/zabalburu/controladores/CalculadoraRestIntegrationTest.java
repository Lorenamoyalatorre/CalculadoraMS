package org.zabalburu.controladores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Iniciamos servidor embebido con puerto aleatorio para poder lanzar las pruebas de integración
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculadoraRestIntegrationTest {

	/*con el autowired inyectamos dependencias, en este caso es un TestRestTemplate
	 * Es una clase de Spring boot test idonea para hacer test de integración */
	@Autowired
	private TestRestTemplate template;

	/*Se construyen los test. Estamos probando lo mismo de dos maneras distintas
	 * 1 Test- Se prueba que el resultado sea 10 (linea 32 y 39)
	 * 2- en el segundo test utilizamos metodos para comprobar estado 
	 * de la respuesta, que sea OK, código 200 (linea 38) y que el resultado
	 * de la respuesta sea 10(linea 39)
		*/
    @Test
    public void testGetSumaUsingGetForObject() {
    	double resultado = template.getForObject("/calculadora/suma?a={a}&b={b}", double.class, 5, 5);
    	assertThat(resultado).isEqualTo(10);
    }
    
    @Test
    public void testGetSumaUsingGetForEntity() {
    	ResponseEntity<Double> respuesta = template.getForEntity("/calculadora/suma?a={a}&b={b}", Double.class, 5, 5);
    	assertEquals(HttpStatus.OK, respuesta.getStatusCode());
    	assertThat(respuesta.getBody()).isEqualTo(10);
    }
    
    // lanzamos una peticion get contra una url que no existe y comprobamos
    // que el codigo de respuesta es un 404 (NOT FOUND)
    @Test
    public void testGetUrlNoExistente() {
    	ResponseEntity<String> respuesta = template.getForEntity("/calculadora/operacionInventada", String.class);
    	assertThat(respuesta.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
    
}

/* Estas pruebas de integración tambien se pueden hacer desde POSTMAN 
 * Prueba unitaria: prueba un único método de una clase.
		El alcance es muy reducido y está perfectamente acotado.
 		Cualquier dependencia a terceros del módulo bajo prueba debe ser sustituida por un mock
	
	Prueba de integración: prueba la interacción entre dos o más elementos,
		que pueden ser clases, módulos, paquetes, subsistemas, etc… 
		incluso la interacción del sistema con el entorno de producción.
 * 
 * */

