package ar.edu.unju.fi.service;

import java.time.LocalDate;

public interface IPesoIdealService {
	Double calcularPesoIdeal(double estatura, int edad);
	
	int calcularEdad(LocalDate fechaNacimiento);
}
