package ar.edu.unju.fi.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.persistence.GeneratedValue;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Base64;
import java.util.UUID;

import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;
import ar.edu.unju.fi.util.UploadFile;


@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	@Autowired
	private IRecetaService recetaService;
	@Autowired
	private UploadFile uploadFile;

	
//	 public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	 
@GetMapping
public String getRecetasPage(Model model) {
	model.addAttribute("recetas", recetaService.getLista());
	return "recetas";
}



@GetMapping("/nuevo")
public String getNuevaRecetaPage(Model model) {
	boolean edicion = false ;
	model.addAttribute("receta", recetaService.getReceta());
	//model.addAttribute("categorias");
	model.addAttribute("edicion",edicion);
	return "nueva_receta";
}

@GetMapping("/modificar/{id}")
public String getModificarRecetaPage(Model model,@PathVariable(value="id")Long id){
	boolean edicion = true;
	Receta recetaEncontrada = recetaService.getBy(id);
	model.addAttribute("receta", recetaEncontrada);
	//model.addAttribute("categorias");
	model.addAttribute("edicion",edicion);
	
	return "nueva_receta";	
}

/*@PostMapping("/modificar")
public ModelAndView postModificarRecetaPage(@Valid @ModelAttribute("receta")Receta receta, BindingResult result) {
	ModelAndView modelView = new ModelAndView("recetas");
	boolean edicion = true;
	if(result.hasErrors()) {
		modelView.setViewName("nueva_receta");
		modelView.addObject("receta", receta);
		//modelView.addObject("categorias");
		modelView.addObject("edicion", edicion);
		return modelView;
	}
	recetaService.guardar(receta);
	modelView.addObject("recetas", recetaService.getLista());
	return modelView;
}*/
@PostMapping("/modificar")
public ModelAndView postModificarRecetaPage(@Valid @ModelAttribute("receta")Receta receta, BindingResult result, @RequestParam("file") MultipartFile imagen) throws Exception  {
	ModelAndView modelView = new ModelAndView("recetas");
	boolean edicion = true;
	if(result.hasErrors()) {
		modelView.setViewName("nueva_receta");
		modelView.addObject("receta", receta);
		//modelView.addObject("categorias");
		modelView.addObject("edicion", edicion);
		return modelView;
	}
	Receta areceta = recetaService.getBy(receta.getId());
    if (!imagen.isEmpty()) {
        if (areceta.getImagen() != null && areceta.getImagen().length() > 0) {
            uploadFile.delete(areceta.getImagen());
        }
        String uniqueFileName = uploadFile.copy(imagen);
        receta.setImagen(uniqueFileName);
    } else {
        if (areceta.getImagen() != null) {
            receta.setImagen(areceta.getImagen());
        }
    }
    if (areceta.getImagen() != null) {
        receta.setImagen(areceta.getImagen());
    }

    if (!imagen.isEmpty()) {
        String uniqueFileName = uploadFile.copy(imagen);
        receta.setImagen(uniqueFileName);
    }
	recetaService.guardar(receta);
	modelView.addObject("recetas", recetaService.getLista());
	return modelView;
 }
    

@PostMapping("/guardar")
public ModelAndView guardarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result,
		@RequestParam("file") MultipartFile imagen) throws Exception {
	ModelAndView modelView = new ModelAndView("recetas");

	if(result.hasErrors()) {
		modelView.setViewName("nueva_receta");
		modelView.addObject("receta", receta);
		//modelView.addObject("categorias", commonService.getConsejoCategoria());
		System.out.print("aaaa");
		return modelView;
	}else{
		if (receta.getId() != null ) {
	    Receta areceta = recetaService.getBy(receta.getId());
	    if (!imagen.isEmpty()) {
	        if (areceta.getImagen() != null && areceta.getImagen().length() > 0) {
	            uploadFile.delete(areceta.getImagen());
	        }
	        String uniqueFileName = uploadFile.copy(imagen);
	        receta.setImagen(uniqueFileName);
	    } else {
	        if (areceta.getImagen() != null) {
	            receta.setImagen(areceta.getImagen());
	        }
	    }
	    if (areceta.getImagen() != null) {
            receta.setImagen(areceta.getImagen());
        }
    
    receta.setId(receta.getId() - 1);
    recetaService.guardar(receta);

	} else {
	    if (!imagen.isEmpty()) {
	        String uniqueFileName = uploadFile.copy(imagen);
	        receta.setImagen(uniqueFileName);
	    }
	}
	recetaService.guardar(receta);
	modelView.addObject("recetas", recetaService.getLista());
	}

	return modelView;
}



@GetMapping("/eliminar/{id}")
public String eliminarRecetas(@PathVariable(value="id") Long id) {
			Receta recetaEncontrada = recetaService.getBy(id);
			recetaService.eliminar(recetaEncontrada);

	
	 return"redirect:/recetas";
}

@GetMapping("/uploads/{filename}")
public ResponseEntity<Resource> goImage(@PathVariable String filename){
	Resource resource = null;
	try {
			resource =uploadFile.load(filename);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename()+ "\" ")
						.body(resource);
}

@GetMapping("/mostrar/{id}")
public ModelAndView getPageMostrarReceta(@PathVariable("id") Long id) {
	ModelAndView modelView = new ModelAndView("mostrar_receta");
	Receta receta = recetaService.getBy(id);
	modelView.addObject("receta", receta);
	return modelView;
}
}
