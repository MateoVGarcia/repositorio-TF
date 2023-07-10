package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.repository.IRegistrarseRepository;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import ar.edu.unju.fi.service.IRegistrarseService;
import ar.edu.unju.fi.service.ITestimonioService;

@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	//Inyeccion de dependencia de las distintas entidades
	
	@Autowired
	IRecetaService recetaService;
	
	@Autowired
	IIngredienteService ingredService;
	
	@Autowired 
	IIndiceMasaCorporalService imcService;
	
	@Autowired
	IRegistrarseService registroService;
	
	@Autowired
	ITestimonioService testimonioService;
	
	@Autowired
	ICommonService commonService;
	
	@Autowired
	IRegistrarseRepository regRepository;
	
	
	//Obtener pagina inicial de Gestion
	@GetMapping
	public String getGestionPage() {
		return "gestion";
	}
	

	//Ir a la pagina de gestion de entidades
	@PostMapping("/admin")
	public String postGestionAdmin(@RequestParam(value = "id") Long id, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	    //En el caso que el id ingresado pertenezca a un registro existente
	    if (optionalRegistro.isPresent()) {
	    	Registro registroEncontrado = optionalRegistro.get();
	    	//Si el usuario es un administrador devuelve las distintas listas
	    	if(registroEncontrado.isAdmin()==true) {
	        model.addAttribute("recetas", recetaService.getLista());
	        model.addAttribute("ingredientes", ingredService.getLista());
	        model.addAttribute("IMCs", imcService.getLista());
	        model.addAttribute("registros", registroService.getListaR());
	        model.addAttribute("testimonios", testimonioService.getListaT());
	        //Si no es administrador devuelve mensaje de error
	    	} else {
	    		model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario con privilegios de administrador");
	    	    return "gestion";
	    	}
	    }
	    //En el caso que el id ingresado no pertenezca a ningun registro existente
	    if(optionalRegistro.isEmpty()) {
	    	//Se manda un mensaje de error
	    model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario");
	    return "gestion";
	    }
	    

	    return "gestionTabla";
	}
}

