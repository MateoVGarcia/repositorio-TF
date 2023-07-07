package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Contacto;
import jakarta.validation.Valid;


@Controller
public class ContactoController {
	

	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "contacto";
	}
	
	
	@PostMapping("/contacto")
	public ModelAndView submitContactoForm(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("contacto");
		}
		ModelAndView modelAndView = new ModelAndView("contacto");
	    modelAndView.addObject("mensaje", "¡Gracias por contactarnos!");    
	    return modelAndView;
	}
}
