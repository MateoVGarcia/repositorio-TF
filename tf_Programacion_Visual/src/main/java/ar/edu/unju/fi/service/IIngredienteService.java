package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;

public interface IIngredienteService {
	//Listado de ingredientes
	List<Ingrediente> getLista();
	//Guardado de ingredientes
	void guardar(Ingrediente ingred);
	//Obtener un ingrediente segun su descripcion
	Ingrediente getBy(Long id);
	//Eliminar un ingrediente
	void eliminar(Ingrediente ingredienteEncontrado);
	//Generar un nuevo ingrediente
	Ingrediente getIngrediente();
}
