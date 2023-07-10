package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.lista.ListaCategoriaReceta;
import ar.edu.unju.fi.service.ICommonService;

@Service
public class CommonServiceImp implements ICommonService{
	@Autowired
	ListaCategoriaReceta listaCategoriaReceta;

	@Override
	public List<String> getRecetasCategoria() {
		return listaCategoriaReceta.getCategorias();
	}
}
