package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaRegistrarseCategoria {
	
private List<String> categorias;
	
	public ListaRegistrarseCategoria() {
		categorias= new ArrayList<String>();
		categorias.add("Eliga un sexo");
		categorias.add("Masculino");
		categorias.add("Femenino");
		categorias.add("Otros");
	}
	
	public List<String> getRegistroCategoria(){
		return categorias;
	}
	
	public void setRegistroCategoria(List<String> categorias) {
		this.categorias = categorias;
	}
}
