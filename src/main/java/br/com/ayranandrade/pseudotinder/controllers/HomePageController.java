package br.com.ayranandrade.pseudotinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	@GetMapping("/")
	public String home() {
		return "anonymous/login";
	}
}
