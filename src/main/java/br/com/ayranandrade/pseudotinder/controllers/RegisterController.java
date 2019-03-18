package br.com.ayranandrade.pseudotinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ayran
 */
@Controller
public class RegisterController {

	@GetMapping("/register")
	public String registerPage() {
		return "anonymous/register";
	}

}
