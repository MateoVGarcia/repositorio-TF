package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;

public interface IIngredienteRepository extends CrudRepository<Ingrediente, Long>{

	public List<Ingrediente> findByEstado(boolean estado);
	

	
}