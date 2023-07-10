package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.IRegistrarseRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	@Autowired
	ITestimonioService testimonioService;
	@Autowired
	IRegistrarseRepository regRepository;
	
	@GetMapping
	public String getTestimonioPage(Model model) {
		model.addAttribute("testimonioLista", testimonioService.getListaT());
		return "testimonios";
	}
	
	@PostMapping("/guardar")
	public String getNuevoTestimonioPage(Model model, @RequestParam(value="id") Long id, @RequestParam(value="comentario")String comentario, RedirectAttributes attributes) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	     if (optionalRegistro.isPresent()) {
	         Registro registroEncontrado = optionalRegistro.get();
	         Testimonio nuevoTestimonio = testimonioService.getTestimonio();
	         nuevoTestimonio.setUsuario(registroEncontrado);
	         nuevoTestimonio.setComentario(comentario);
	         testimonioService.guardarTestimonio(nuevoTestimonio);
	         }
	     if(optionalRegistro.isEmpty()) {
	         attributes.addFlashAttribute("error", "El ID ingresado no pertenece a un usuario existente");
	         return "redirect:/testimonios";
	     }
	     model.addAttribute("testimonioLista", testimonioService.getListaT());
	    return "testimonios";
	}


}
