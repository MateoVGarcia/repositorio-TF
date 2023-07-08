package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ar.edu.unju.fi.entity.Receta;

@Repository
public interface IRecetaRepository extends CrudRepository<Receta, Long>{

	public List<Receta> findByEstado(boolean estado);
	
}
