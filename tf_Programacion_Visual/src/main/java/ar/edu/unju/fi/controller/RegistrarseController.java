package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Registro;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IRegistrarseService;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/registrarse")
public class RegistrarseController {

	@Autowired
	private IRegistrarseService registrarseService;
	@Autowired
	private ICommonService commonService;

	@GetMapping("/nuevo")
	public String getNuevoRegistroPage(Model model) {
		boolean edicion = false;
		Registro registro = new Registro();
		model.addAttribute("registro", registro);
		model.addAttribute("sexo", commonService.getRegistroSexo());
		model.addAttribute("edicion", edicion);
		return "nuevo_registro";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarRegistroPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Registro registroEncontrado = registrarseService.getBy(id);
		if (registroEncontrado == null) {
			return "redirect:/gestion";
		}
		model.addAttribute("registro", registroEncontrado);
		model.addAttribute("sexo", commonService.getRegistroSexo());
		model.addAttribute("edicion", edicion);
		return "nuevo_registro";
	}

	@PostMapping("/modificar")
	public ModelAndView modificarRegistro(@Valid @ModelAttribute("registro") Registro registro, BindingResult result) {
		ModelAndView modelView = new ModelAndView("registrarse");
		boolean edicion = true;
		if (result.hasErrors()) {
			modelView.setViewName("nuevo_registro");
			modelView.addObject("registro", registro);
			modelView.addObject("sexo", commonService.getRegistroSexo());
			modelView.addObject("edicion", edicion);
			return modelView;
		}
		registrarseService.guardarRegistro(registro);
		return new ModelAndView("redirect:/gestion");
	}

	@PostMapping("/guardar")
	public ModelAndView guardarRegistro(@Valid @ModelAttribute("registro") Registro registro,
			BindingResult bindingResult) {
		ModelAndView modelView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			// Si hay errores de validación, regresar al formulario con los errores
			modelView.addObject("sexo", commonService.getRegistroSexo());
			modelView.setViewName("nuevo_registro");
			modelView.addObject("registro", registro);
			return modelView;
		} else {
			// Si no hay errores, guardar el registro en la base de datos
			registrarseService.guardarRegistro(registro);

			// Obtener la lista actualizada de registros
			List<Registro> registros = registrarseService.getListaR();

			modelView.setViewName("registrarse");
			modelView.addObject("mensaje", "Registro exitoso! Tu nuevo numero de ID es: " + registro.getId() + ". Guardalo bien.");
			modelView.addObject("registros", registros);
			modelView.addObject("sexo", null); // Restablecer la categoría (puedes ajustar esto según tu lógica)

			return modelView;
		}
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarRegistro(@PathVariable(value = "id") Long id) {
		Registro registroEncontrado = registrarseService.getBy(id);
		registrarseService.eliminarRegistro(registroEncontrado);
		return "redirect:/gestion";
	}
}