package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Contacto;

@Controller
public class ContactoController {
	
	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "contacto";
	}
	
	
	@PostMapping("/contacto")
	public ModelAndView submitContactoForm(@ModelAttribute("contacto") Contacto contacto) {
	    
		//Como no tengo la coneccion con la Base de datos, Imprimo los datos en la consola
	    System.out.println("Nombre: " + contacto.getNombre());
	    System.out.println("Email: " + contacto.getEmail());
	    System.out.println("Ciudad: " + contacto.getCiudad());
	    System.out.println("Mensaje: " + contacto.getMensaje());
		
		ModelAndView modelAndView = new ModelAndView("contacto");
	    modelAndView.addObject("mensaje", "¡Gracias por contactarnos!");    
	    return modelAndView;
	}
}
