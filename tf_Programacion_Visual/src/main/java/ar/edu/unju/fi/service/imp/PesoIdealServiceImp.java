package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.IPesoIdealService;

@Service("PesoIdealService")
public class PesoIdealServiceImp implements IPesoIdealService {

	 @Override
	    public Double calcularPesoIdeal(double estatura, int edad) {
	        return estatura - 100 + (edad / 10) * 0.9;
	    }
	 
	 
	 @Override
	 public int calcularEdad(LocalDate fechaNacimiento) {
		    LocalDate fechaActual = LocalDate.now();
		    Period periodo = Period.between(fechaNacimiento, fechaActual);
		    return periodo.getYears();
		}
	 

}
