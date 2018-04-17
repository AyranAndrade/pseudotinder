package br.com.ayranandrade.pseudotinder.controllers;

import br.com.ayranandrade.pseudotinder.models.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("people", new People());
    return "login";
  }
}
