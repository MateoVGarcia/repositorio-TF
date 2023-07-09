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
	
	
	
	@GetMapping("/listado")
	public String getListadoRegistrosPage(Model model, @RequestParam(name = "categoriaR", required = false) String categoriaR) {
	    List<Registro> registros = registrarseService.getListaR(categoriaR);
	    model.addAttribute("registros", registros); // Asegúrate de agregar la lista al modelo con el nombre "registros"
	    model.addAttribute("categoriaR", categoriaR);
	    return "registrarse";
	}

    @GetMapping("/nuevo")
    public String getNuevoRegistroPage(Model model) {
        boolean edicion = false;
        Registro registro = new Registro();
        model.addAttribute("registro", registro);
        model.addAttribute("categorias", commonService.getRegistroCategoria());
        model.addAttribute("edicion", edicion);
        return "nuevo_registro";
    }

    @GetMapping("/modificar/{id}")
    public String getModificarRegistroPage(Model model, @PathVariable(value = "id") Long id) {
        boolean edicion = true;
        Registro registroEncontrado = registrarseService.getBy(id);
        if (registroEncontrado == null) {
            return "redirect:/registrarse/listado";
        }
        model.addAttribute("registro", registroEncontrado);
        model.addAttribute("categorias", commonService.getRegistroCategoria());
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
            modelView.addObject("categorias", commonService.getRegistroCategoria());
            modelView.addObject("edicion", edicion);
            return modelView;
        }
        registrarseService.guardarRegistro(registro);
        return new ModelAndView("redirect:/registrarse/listado");
    }

    @PostMapping("/guardar")
    public ModelAndView guardarRegistro(@Valid @ModelAttribute("registro") Registro registro, BindingResult result) {
        ModelAndView modelView = new ModelAndView("registrarse");
        if (result.hasErrors()) {
            modelView.setViewName("nuevo_registro");
            modelView.addObject("registro", registro);
            modelView.addObject("categorias", commonService.getRegistroCategoria());
            return modelView;
        }
        registrarseService.guardarRegistro(registro);
        List<Registro> registros = registrarseService.getListaR(null);  // Obtener la lista actualizada de registros
        modelView.addObject("registros", registros);  // Agregar la lista al modelo
        modelView.addObject("categoriaR", null);  // Restablecer la categoría (puedes ajustar esto según tu lógica)
        return modelView;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable(value = "id") Long id) {
        Registro registroEncontrado = registrarseService.getBy(id);
        registrarseService.eliminarRegistro(registroEncontrado);
        return "redirect:/registrarse/listado";
    }
}