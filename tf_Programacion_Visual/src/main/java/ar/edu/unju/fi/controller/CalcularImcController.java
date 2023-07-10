package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;


@Controller
public class CalcularImcController {
	
	@Autowired
	@Qualifier("indiceMasaCorporalServiceImp")
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	
	
	@GetMapping("/calcularImc")
	public String getCalcularImcPage() {
		return "calcularImc";
	}
	
	
	 @GetMapping("/{codigo}/imc")
	    public String mostrarRegistrosIMC(@PathVariable String codigo, Model model) {
	        List <IndiceMasaCorporal> registrosIMC = indiceMasaCorporalService.getRegistrosIMCOrdenadosPorFechaDesc(codigo);
	        model.addAttribute("registrosIMC", registrosIMC);
	        return "calcularImc";
	    }

	 
	 @PostMapping("/{codigo}/imc/calcular")
	  public String calcularIMC(@PathVariable String codigo, @RequestParam double peso) {
		 indiceMasaCorporalService.calcularIMC(codigo, peso);
	   return "redirect:/usuario/" + codigo + "/imc";
	  }
}
