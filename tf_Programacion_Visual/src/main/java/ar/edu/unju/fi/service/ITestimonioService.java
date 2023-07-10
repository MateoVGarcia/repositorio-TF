package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;


public interface ITestimonioService {
	
	    
		// Listar testimonio
	    List<Testimonio> getListaT();

	    // Guardar testimonio
	    void guardarTestimonio(Testimonio testimonio);

	    // Obtener testimonio por código
	    public Testimonio getBy(Long id);

	    // Eliminar un testimonio
	    void eliminarTestimonio(Testimonio testimonioEncontrado);

	    // Obtener testimonio nuevo
	     Testimonio getTestimonio();

	}

