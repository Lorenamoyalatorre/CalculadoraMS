package org.zabalburu.servicio;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	
	public double suma(double a, double b) {
		return a+b;
	}
	
	public double resta(double a, double b) {
		return a-b;
	}
	
	public double multiplicacion(double a, double b) {
		return a*b;
	}
	
	public double division(double a, double b) {
		return a/b;
	}
	
	public double potencia(double a, double b) {
		return Math.pow(a, b);
	}
}
