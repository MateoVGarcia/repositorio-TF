package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.listas.ListaRegistrarseCategoria;

@Service
public class CommonServiceImp implements ICommonService {

	@Autowired
    ListaRegistrarseCategoria listaRegistrarseCategoria;
    
	@Override
	public List<String> getRegistroCategoria() {
		return listaRegistrarseCategoria.getRegistroCategoria();
	}
}
