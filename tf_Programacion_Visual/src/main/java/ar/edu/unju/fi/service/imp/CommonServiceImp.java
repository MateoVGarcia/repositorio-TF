package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.listas.ListaCategoriaReceta;
import ar.edu.unju.fi.listas.ListaRegistrarseSexo;

@Service
public class CommonServiceImp implements ICommonService {

	@Autowired
    ListaRegistrarseSexo listaRegistrarseSexo;
    
	@Override
	public List<String> getRegistroSexo() {
		return listaRegistrarseSexo.getRegistroSexo();
	}
	
	@Autowired
	ListaCategoriaReceta listaCategoriaReceta;

	@Override
	public List<String> getRecetasCategoria() {
		return listaCategoriaReceta.getCategorias();
	}
}
