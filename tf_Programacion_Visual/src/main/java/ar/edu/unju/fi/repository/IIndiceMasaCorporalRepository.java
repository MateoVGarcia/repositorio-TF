package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.*;

public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long>{

	public List<IndiceMasaCorporal> findByEstado(boolean estado);
}
