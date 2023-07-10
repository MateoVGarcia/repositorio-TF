package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.repository.IRegistrarseRepository;
import ar.edu.unju.fi.service.IPesoIdealService;
import ar.edu.unju.fi.service.IRegistrarseService;

@Controller
@RequestMapping("/pesoIdeal")
public class PesoIdealController {

	@Autowired 
	private IRegistrarseRepository regRepository;
	
	@Autowired 
	private IRegistrarseService registroService;

	  @Autowired
	  private IPesoIdealService pesoIdealService;

	    
	@GetMapping
	public String getPesoIdealPage() {
		return "pesoIdeal";
	}
	
	
	@PostMapping("/calculoPesoIdeal")
	public String calcularPesoIdeal(@RequestParam(value = "id") Long id, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);

	    if (optionalRegistro.isPresent()) {
	        Registro registroEncontrado = optionalRegistro.get();
	        Double altura = registroEncontrado.getEstatura();
	        LocalDate fechaNacimiento = registroEncontrado.getNacimiento();

	        int edad = pesoIdealService.calcularEdad(fechaNacimiento);
	        Double pesoIdeal = pesoIdealService.calcularPesoIdeal(altura, edad);

	        model.addAttribute("pesoIdeal", pesoIdeal);
	        return "pesoIdeal";
	    }

	    model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario");
	    return "error";
	}
	
	
	
	
}
