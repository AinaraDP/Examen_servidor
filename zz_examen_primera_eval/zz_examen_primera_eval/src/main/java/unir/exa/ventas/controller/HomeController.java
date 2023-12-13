package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.repository.ComercialRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ComercialRepository comrepo;
	
	
	@GetMapping({"", "/", "/home"})
	public String home(Model model) {
		List<Comercial> comerciales = comrepo.findAll();
		model.addAttribute("comerciales", comerciales);
		
		return "home";
	}
	
}
	

