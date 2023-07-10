package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;

public interface IIndiceMasaCorporalService {
    
	// Listar IMC
    List<IndiceMasaCorporal> getLista();

    // Guardar productos
    void guardarIMC(IndiceMasaCorporal imc);

    // Obtener producto por código
    public IndiceMasaCorporal getBy(Long id);

    // Eliminar un producto
    void eliminarIMC(IndiceMasaCorporal imcEncontrado);

    // Obtener producto nuevo
    IndiceMasaCorporal getIMC();
    
    Double calcularIMC(Double peso, Double altura);

}
