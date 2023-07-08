package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {

	//Listado de Consejos
	List<Receta> getLista();
	//Guardado de consejos
	void guardar(Receta receta);
	//Obtener un consejo segun su descripcion
	Receta getBy(Long id);
	//Eliminar un consejo
	void eliminar(Receta recetaEncontrada);
	//Generar un nuevo consejo
	Receta getReceta();
}
