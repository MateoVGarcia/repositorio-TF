package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

@Service("ingredienteServiceImp")
public class IngredienteServiceImp implements IIngredienteService {
	@Autowired
	Ingrediente ingred;
	@Autowired
	IIngredienteRepository ingredRepo;
	
	@Override
	public List<Ingrediente> getLista() {
		return ingredRepo.findByEstado(true);
	}

	@Override
	public void guardar(Ingrediente ingred) {
		ingred.setEstado(true);
		ingredRepo.save(ingred);
	}

	@Override
	public Ingrediente getBy(Long id) {
		return ingredRepo.findById(id).get();
	}

	@Override
	public void eliminar(Ingrediente ingredienteEncontrado) {
		ingredienteEncontrado.setEstado(false);
		ingredRepo.save(ingredienteEncontrado);
		
	}

	@Override
	public Ingrediente getIngrediente() {
		return ingred;
	}
}