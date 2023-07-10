package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {

	//Listado de recetas
	List<Receta> getLista();
	//Guardado de recetas
	void guardar(Receta receta);
	//Obtener un receta segun su id
	Receta getBy(Long id);
	//Obtener recetas segun categoria
	List<Receta> getListaCategoria(String categoria);
	//Eliminar una receta
	void eliminar(Receta recetaEncontrada);
	//Generar una nueva receta
	Receta getReceta();
}
