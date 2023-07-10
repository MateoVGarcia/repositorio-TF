package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.repository.IRegistrarseRepository;
import ar.edu.unju.fi.service.IRegistrarseService;

@Service
public class RegistrarseServiceImp implements IRegistrarseService {

	@Autowired
    private IRegistrarseRepository registrarseRepository;
	@Autowired
	private Registro registro;

	@Override
	public List<Registro> getListaR(String categoriaR) {
        return registrarseRepository.findByEstado(true);
    }

	@Override
	public void guardarRegistro(Registro registro) {
		registro.setEstado(true);
		registrarseRepository.save(registro);
		// TODO Auto-generated method stub

	}

	@Override
	public Registro getBy(Long id){
		return registrarseRepository.findById(id).get();
	}



	@Override
	public void eliminarRegistro(Registro registroEncontrado) {
		registroEncontrado.setEstado(false);
		registrarseRepository.save(registroEncontrado);
	}

	@Override
	public Registro getRegistro() {

		return registro;
	}


}