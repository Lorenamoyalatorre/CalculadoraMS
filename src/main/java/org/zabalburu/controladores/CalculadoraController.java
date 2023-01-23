package org.zabalburu.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zabalburu.servicio.CalculadoraService;

@Controller
public class CalculadoraController {
	
	@Autowired
	private CalculadoraService servicio;
	
	@GetMapping("/")
	public String getCalculadora() {
		return "calculadora";
	}
	
	@PostMapping("/")
	public String calular(Model modelo,
			@RequestParam double a, 
			@RequestParam double b, 
			@RequestParam String operacion) {
		double resp = 0;
		switch (operacion) {
			case "+": {
				resp = servicio.suma(a, b);
				break;
			}
			case "-": {
				resp = servicio.resta(a, b);
				break;
			}
			case "*": {
				resp = servicio.multiplicacion(a, b);
				break;
			}
			case "/": {
				resp = servicio.division(a, b);
				break;
			}
			case "**": {
				resp = servicio.potencia(a, b);
				break;
			}
		}
		modelo.addAttribute("resp",resp);
		return "calculadora";
		
	}
}
