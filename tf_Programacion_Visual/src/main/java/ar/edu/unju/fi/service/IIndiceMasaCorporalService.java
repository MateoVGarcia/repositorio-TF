package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;

public interface IIndiceMasaCorporalService {
    
	// Listar IMC
    List<IndiceMasaCorporal> getLista();

    // Guardar IMC
    void guardarIMC(IndiceMasaCorporal imc);

    // Obtener IMC por id
    public IndiceMasaCorporal getBy(Long id);

    // Eliminar un IMC
    void eliminarIMC(IndiceMasaCorporal imcEncontrado);

    // Obtener IMC nuevo
    IndiceMasaCorporal getIMC();
    
    //Calcular el IMC de una persona
    String calcularIMC(Double peso, Double altura);

}
