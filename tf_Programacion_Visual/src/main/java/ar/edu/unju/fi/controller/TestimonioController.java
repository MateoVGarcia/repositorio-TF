package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.entity.Testimonio;

@Controller
public class TestimonioController {
	@Autowired
	@GetMapping("/testimonio")
	public String getTestimonioPage(Model model) {
		model.addAttribute("testimonio", new Testimonio());
		return "testimonio";
	}
	
	
}
