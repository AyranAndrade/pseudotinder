package br.com.ayranandrade.pseudotinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.ayranandrade.pseudotinder.models.Person;

/**
 *
 * @author ayran
 */
@Controller
public class RegisterController {

	@GetMapping("/register/one")
	public String registerPage(Model model) {
		model.addAttribute("person", new Person());
		return "anonymous/registerOne";
	}

	@PostMapping("/register")
	public String registerPageOne() {
		return "redirect:/";
	}

}
