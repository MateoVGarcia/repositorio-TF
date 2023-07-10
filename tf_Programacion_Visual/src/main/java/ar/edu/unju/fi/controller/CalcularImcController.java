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
	//Obtener la pagina de calculo de IMC
	public String getCalcularImcPage(Model model) {
		 model.addAttribute("mostrarBotonVolver", true);
		model.addAttribute("imc", indiceMasaCorporalService.getIMC());
		return "calcularImc";
	}
	
	//Calculo de IMC y validacion de id
	@PostMapping("/calculo")
	public String calcularIMC(@RequestParam(value = "id") Long id, @RequestParam(value = "peso") Double peso, Model model) {
	    Optional<Registro> optionalRegistro = regRepository.findById(id);
	    //Si el id pertenece a un registro existente
	    if (optionalRegistro.isPresent()) {
	        Registro registroEncontrado = optionalRegistro.get();
	        Double altura = registroEncontrado.getEstatura();
	        IndiceMasaCorporal imc = indiceMasaCorporalService.getIMC();
	        //Se calcula el imc y se settea el imc.
	        imc.setImc(indiceMasaCorporalService.calcularIMC(peso, altura));
	        imc.setUsuario(registroEncontrado.getNombre() + " " + registroEncontrado.getApellido());
	        imc.setRegistro(registroEncontrado);
	        //Si el id del IMC está repetido, se le suma 1 para que sea uno nuevo
	        if (imc.getId() != null) {
	            imc.setId(imc.getId() + 1);
	        }
	        //Se guarda tanto el IMC como el registro (Se le agrego un IMC a su lista)
	        indiceMasaCorporalService.guardarIMC(imc);
	        registroEncontrado.añadirImc(imc);
	        registroService.guardarRegistro(registroEncontrado);

	        model.addAttribute("resultadoIMC", imc.getImc());
	        model.addAttribute("registro", registroEncontrado);
	    }
	    //En el caso de que no sea válido el id ingresado, se manda un mensaje de error
	    if(optionalRegistro.isEmpty()) {
	    model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario");
	    return "calcularImc";
	    }
        return "ImcTabla";
	}
	 

}
