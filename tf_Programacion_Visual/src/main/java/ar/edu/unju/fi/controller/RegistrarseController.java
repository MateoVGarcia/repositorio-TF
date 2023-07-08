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
@RequestMapping("/nuevo_registro")
public class RegistrarseController {

    private final IRegistrarseService registrarseService;
    private final ICommonService commonService;

    @Autowired
    public RegistrarseController(IRegistrarseService registrarseService, ICommonService commonService) {
        this.registrarseService = registrarseService;
        this.commonService = commonService;
    }

    @GetMapping("/listado")
    public String getListadoRegistrosPage(Model model, @RequestParam(name = "categoriaR", required = false) String categoriaR) {
        List<Registro> registros = registrarseService.getListaR(categoriaR);
        model.addAttribute("registros", registros);
        model.addAttribute("categoriaR", categoriaR);
        return "nuevo_registro";
    }

    @GetMapping("/nuevo")
    public String getNuevoRegistroPage(Model model) {
        Registro registro = new Registro();
        model.addAttribute("registro", registro);
        model.addAttribute("categorias", commonService.getRegistroCategoria());
        model.addAttribute("edicion", false);
        return "registrarse";
    }

    @GetMapping("/modificar/{id}")
    public String getModificarRegistroPage(@PathVariable(value = "id") Long id, Model model) {
        Registro registroEncontrado = registrarseService.getBy(id);
        if (registroEncontrado == null) {
            return "redirect:/nuevo_registro/listado";
        }
        model.addAttribute("registro", registroEncontrado);
        model.addAttribute("categorias", commonService.getRegistroCategoria());
        model.addAttribute("edicion", true);
        return "registrarse";
    }

    @PostMapping("/guardar")
    public String guardarRegistro(@Valid @ModelAttribute("registro") Registro registro, BindingResult result) {
        if (result.hasErrors()) {
            return "registrarse";
        }
        registrarseService.guardarRegistro(registro);
        return "redirect:/nuevo_registro/listado";
    }

    @PostMapping("/modificar")
    public String modificarRegistro(@Valid @ModelAttribute("registro") Registro registro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", commonService.getRegistroCategoria());
            model.addAttribute("edicion", true);
            return "registrarse";
        }
        registrarseService.guardarRegistro(registro);
        return "registrarse";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable(value = "id") Long id) {
        Registro registroEncontrado = registrarseService.getBy(id);
        registrarseService.eliminarRegistro(registroEncontrado);
        return "redirect:/nuevo_registro/listado";
    }
}