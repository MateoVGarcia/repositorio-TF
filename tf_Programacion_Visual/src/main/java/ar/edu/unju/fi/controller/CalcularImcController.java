package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IRegistrarseService;


@Controller
@RequestMapping("/calcularImc")
public class CalcularImcController {
	
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	@Autowired 
	private IRegistrarseService registroService;
	
	
	@GetMapping
	public String getCalcularImcPage(Model model) {
		model.addAttribute("imc", indiceMasaCorporalService.getIMC());
		return "calcularImc";
	}
	
	
	
	 @PostMapping("/calculo")
	  public String calcularIMC(@RequestParam(value = "id") Long id, @RequestParam(value = "peso") Double peso, Model model) {
		Registro registroEncontrado = registroService.getBy(id);
		if (registroEncontrado != null) {
			Double altura = registroEncontrado.getEstatura();
			IndiceMasaCorporal imc = indiceMasaCorporalService.getIMC();
			imc.setImc(indiceMasaCorporalService.calcularIMC(peso, altura));
			imc.setUsuario(registroEncontrado.getNombre() + " " +registroEncontrado.getApellido());
			indiceMasaCorporalService.guardarIMC(imc);
			registroEncontrado.añadirImc(imc);
			registroService.guardarRegistro(registroEncontrado);
			
			model.addAttribute("resultadoIMC", imc.getImc());
			model.addAttribute("registro", registroEncontrado);
		}
	   return "ImcTabla";
	  }
	
	
	 

}
