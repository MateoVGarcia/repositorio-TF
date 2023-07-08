package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

@Service("recetaServiceImp")
public class RecetaServiceImp implements IRecetaService {
	@Autowired
	Receta receta;
	@Autowired
	IRecetaRepository recetaRepository;
	
	@Override
	public List<Receta> getLista() {
		return recetaRepository.findByEstado(true);
	}

	@Override
	public void guardar(Receta receta) {
		receta.setEstado(true);
		recetaRepository.save(receta);
		
	}

	@Override
	public Receta getBy(Long id) {
		return recetaRepository.findById(id).get();
	}

	@Override
	public void eliminar(Receta recetaEncontrada) {
		recetaEncontrada.setEstado(false);
		recetaRepository.save(recetaEncontrada);
		
	}

	@Override
	public Receta getReceta() {
		return receta;
	}

}
