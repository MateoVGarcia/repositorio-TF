package ar.edu.unju.fi.service;

import java.time.LocalDate;

public interface IPesoIdealService {
	
	//Calculo del peso ideal
	Double calcularPesoIdeal(Double estatura, int edad);
	
	//Calculo de edad
	int calcularEdad(LocalDate fechaNacimiento);
}
