package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.service.IIngredienteService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/recetas/ingredientes")
public class IngredienteController {
	@Autowired
	IIngredienteService ingredService;
	
	//Pagina con el listado de los consejos (Cada uno está separado por categoría con th:if)
@GetMapping("/listado")
public String getIngredientesPage(Model model) {
	model.addAttribute("ingredientes", ingredService.getLista());
	return "ingredientes";
}


	//Pagina para crear un consejo nuevo
@GetMapping("/nuevo")
public String getNuevoIngredientePage(Model model) {
	boolean edicion = false ;
	model.addAttribute("ingrediente", ingredService.getIngrediente());
	model.addAttribute("edicion",edicion);
	return "nuevo_ingrediente";
}

@GetMapping("/modificar/{id}")
public String getModificarIngredientePage(Model model,@PathVariable(value="id")Long id){
	boolean edicion = true;
	Ingrediente ingredienteEncontrado = ingredService.getBy(id);
	model.addAttribute("ingrediente", ingredienteEncontrado);
	model.addAttribute("edicion",edicion);
	
	return "nuevo_ingrediente";	
}

@PostMapping("/modificar")
public ModelAndView postModificarIngredientePage(@Valid @ModelAttribute("ingrediente")Ingrediente ingrediente, BindingResult result) {
	ModelAndView modelView = new ModelAndView("ingredientes");
	boolean edicion = true;
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_ingrediente");
		modelView.addObject("ingrediente", ingrediente);
		modelView.addObject("edicion", edicion);
		return modelView;
	}
	ingredService.guardar(ingrediente);
	modelView.addObject("ingredientes", ingredService.getLista());
	return modelView;
}

	//Pagina de guardado de los consejos
@PostMapping("/guardar")
public ModelAndView getGuardarIngredientePage(@Valid @ModelAttribute("ingrediente")Ingrediente ingrediente, BindingResult result) {
	ModelAndView modelView = new ModelAndView("ingredientes");
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_ingrediente");
		modelView.addObject("ingrediente", ingrediente);
		return modelView;
	}
	ingredService.guardar(ingrediente);
	modelView.addObject("ingredientes", ingredService.getLista());
	return modelView;
}

	//Pagina para eliminar consejos
@GetMapping("/eliminar/{id}")
public String eliminarIngrediente(@PathVariable(value="id") Long id) {
			Ingrediente ingredienteEncontrado = ingredService.getBy(id);
			ingredService.eliminar(ingredienteEncontrado);

	
	 return"redirect:/recetas/ingredientes";
}
}
