package ar.edu.unju.fi.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.repository.IRegistrarseRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IRegistrarseService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/calcularImc")
public class CalcularImcController {
	
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	@Autowired 
	private IRegistrarseRepository regRepository;
	@Autowired 
	private IRegistrarseService registroService;
	
	
	@GetMapping
	public String getCalcularImcPage(Model model) {
		boolean incorrecto = false;
		model.addAttribute("incorrecto", incorrecto);
		model.addAttribute("imc", indiceMasaCorporalService.getIMC());
		return "calcularImc";
	}
	
	
	@PostMapping("/calculo")
	public String calcularIMC(@RequestParam(value = "id") Long id, @RequestParam(value = "peso") Double peso, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	    
	    if (optionalRegistro.isPresent()) {
	    	boolean incorrecto = false;
	        Registro registroEncontrado = optionalRegistro.get();
	        Double altura = registroEncontrado.getEstatura();
	        
	        IndiceMasaCorporal imc = indiceMasaCorporalService.getIMC();
	        imc.setImc(indiceMasaCorporalService.calcularIMC(peso, altura));
	        imc.setUsuario(registroEncontrado.getNombre() + " " + registroEncontrado.getApellido());
	        imc.setRegistro(registroEncontrado);
	        
	        if (imc.getId() != null) {
	            imc.setId(imc.getId() + 1);
	        }
	        
	        indiceMasaCorporalService.guardarIMC(imc);
	        registroEncontrado.añadirImc(imc);
	        registroService.guardarRegistro(registroEncontrado);
	        
	        model.addAttribute("incorrecto", incorrecto);
	        model.addAttribute("resultadoIMC", imc.getImc());
	        model.addAttribute("registro", registroEncontrado);
	        

	    }
	    if(optionalRegistro.isEmpty()) {
	    boolean incorrecto = true;
	    model.addAttribute("incorrecto", incorrecto);
	    return "redirect:/calcularImc";
	    }
        return "ImcTabla";
	}
	

	/*@PostMapping("/calculo")
	public String calcularIMC(@RequestParam(value = "id") Long id, @RequestParam(value = "peso") Double peso, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	    
	    if (optionalRegistro.isPresent()) {
	    	boolean incorrecto = false;
	        Registro registroEncontrado = optionalRegistro.get();
	        Double altura = registroEncontrado.getEstatura();
	        
	        IndiceMasaCorporal imc = indiceMasaCorporalService.getIMC();
	        imc.setImc(indiceMasaCorporalService.calcularIMC(peso, altura));
	        imc.setUsuario(registroEncontrado.getNombre() + " " + registroEncontrado.getApellido());
	        imc.setRegistro(registroEncontrado);
	        
	        if (imc.getId() != null) {
	            imc.setId(imc.getId() + 1);
	        }
	        
	        indiceMasaCorporalService.guardarIMC(imc);
	        registroEncontrado.añadirImc(imc);
	        registroService.guardarRegistro(registroEncontrado);
	        
	        model.addAttribute("incorrecto", incorrecto);
	        model.addAttribute("resultadoIMC", imc.getImc());
	        model.addAttribute("registro", registroEncontrado);
	        

	    }
	    else {
	    boolean incorrecto = true;
	    model.addAttribute("incorrecto", incorrecto);
	    return "redirect:/calcularImc";
	    }
        return "ImcTabla";
	}
	*/
	 

}
