package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Registro;

@Service
public interface IRegistrarseService {
    
	// Listar productos
    List<Registro> getListaR(String sexo);

    // Guardar productos
    void guardarRegistro(Registro registro);

    // Obtener producto por código
    public Registro getBy(Long id);

    // Eliminar un producto
    void eliminarRegistro(Registro registroEncontrado);

    // Obtener producto nuevo
     Registro getRegistro();

}