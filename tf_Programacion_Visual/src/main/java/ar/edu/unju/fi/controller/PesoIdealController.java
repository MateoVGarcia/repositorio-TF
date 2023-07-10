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
	
	//Calculo de peso ideal
	@PostMapping("/calculo")
	public String calcularPesoIdeal(@RequestParam(value = "id") Long id, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	    //En el caso que el id ingresado pertenezca a un registro existente
	    if (optionalRegistro.isPresent()) {
	        Registro registroEncontrado = optionalRegistro.get();
	        Double altura = registroEncontrado.getEstatura();
	        LocalDate fechaNacimiento = registroEncontrado.getNacimiento();
	        //Se calcula la edad de la persona
	        int edad = pesoIdealService.calcularEdad(fechaNacimiento);
	        //Se calcula el peso ideal de la persona con la fórmula Perrault
	        Double pesoIdeal = pesoIdealService.calcularPesoIdeal(altura, edad);
	        //Se manda como parámetro el peso ideal
	        model.addAttribute("pesoIdeal", pesoIdeal);
	    }
	    //En el caso que el id ingresado no pertenezca a ningun registro existente
	    if(optionalRegistro.isEmpty()) {
	    	//Se manda un mensaje de error
	    model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario");
	    }
	    return "pesoIdeal";
	}
	
	
	
	
}
