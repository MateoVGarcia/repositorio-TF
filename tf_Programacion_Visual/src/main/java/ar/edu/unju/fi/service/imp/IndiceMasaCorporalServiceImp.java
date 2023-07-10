package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.*;

@Service("IndiceMasaCorporalService")
public class IndiceMasaCorporalServiceImp implements IIndiceMasaCorporalService {

	@Autowired
	IIndiceMasaCorporalRepository imcRepository;
	@Autowired 
	IndiceMasaCorporal imc;
	
	@Override
	public List<IndiceMasaCorporal> getLista() {
		return imcRepository.findByEstado(true);
	}

	@Override
	public void guardarIMC(IndiceMasaCorporal imc) {
		imc.setEstado(true);
		imcRepository.save(imc);
		
	}

	@Override
	public IndiceMasaCorporal getBy(Long id) {
		return imcRepository.findById(id).get();
	}

	@Override
	public void eliminarIMC(IndiceMasaCorporal imcEncontrado) {
		imcEncontrado.setEstado(false);
		imcRepository.save(imcEncontrado);
		
	}

	@Override
	public IndiceMasaCorporal getIMC() {
		LocalDate fechaActual = LocalDate.now();
		imc.setFecha(fechaActual);
		return imc;
	}

	@Override
	public String calcularIMC(Double peso, Double altura) {
		Double imc = peso/Math.pow(altura, 2);
		String resultado;
		 if (imc < 18.5) {
		        resultado = "Su IMC es " + imc + " - Está por debajo de su peso ideal.";
		    } else if (imc >= 18.5 && imc <= 25) {
		        resultado = "Su IMC es " + imc + " - Está en su peso normal.";
		    } else {
		        resultado = "Su IMC es " + imc + " - Tiene sobrepeso.";
		    }

		    return resultado;
	}

}
