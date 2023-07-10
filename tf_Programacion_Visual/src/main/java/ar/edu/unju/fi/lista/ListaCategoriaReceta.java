package ar.edu.unju.fi.lista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaCategoriaReceta {
	private List<String> categorias;
	
	public ListaCategoriaReceta() {
		categorias= new ArrayList<String>();
		categorias.add("Carnes");
		categorias.add("Bebidas");
		categorias.add("Dulces");
		categorias.add("Ensaladas");
		categorias.add("Legumbres y Cereales");
		categorias.add("Pescados");
		categorias.add("Pan");
		categorias.add("Sopas y Cremas");
	}
	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}


}
