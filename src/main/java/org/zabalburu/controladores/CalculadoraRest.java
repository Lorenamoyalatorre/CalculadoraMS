package org.zabalburu.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.servicio.CalculadoraService;

@RestController
@RequestMapping("calculadora")
public class CalculadoraRest {

	@Autowired
	private CalculadoraService servicio;
	
	@GetMapping("/suma")
	public double getSuma(@RequestParam double a, @RequestParam double b) {
		return servicio.suma(a, b);
	}
	
	@GetMapping("/resta")
	public double getResta(@RequestParam double a, @RequestParam double b) {
		return servicio.resta(a, b);
	}
	
	@GetMapping("/multiplica")
	public double getMultiplica(@RequestParam double a, @RequestParam double b) {
		return servicio.multiplicacion(a, b);
	}
	
	@GetMapping("/divide")
	public double getDivision(@RequestParam double a, @RequestParam double b) {
		return servicio.division(a, b);
	}
	
	@GetMapping("/potencia")
	public double getPotencia(@RequestParam double a, @RequestParam double b) {
		return servicio.potencia(a, b);
	}
	
}
