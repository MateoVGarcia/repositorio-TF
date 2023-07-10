package ar.edu.unju.fi.service;

import java.time.LocalDate;

public interface IPesoIdealService {
	Double calcularPesoIdeal(Double estatura, int edad);
	
	int calcularEdad(LocalDate fechaNacimiento);
}
