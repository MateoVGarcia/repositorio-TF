package ar.edu.unju.fi.service;

import java.util.List;

public interface ICommonService {
	
	//Lista de Sexo de usuario
	List<String> getRegistroSexo();
	
	//Lista de categorias de recetas
	List<String> getRecetasCategoria();

}
