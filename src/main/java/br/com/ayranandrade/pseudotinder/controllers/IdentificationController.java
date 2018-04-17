package br.com.ayranandrade.pseudotinder.controllers;

import br.com.ayranandrade.pseudotinder.models.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ayran
 */
@Controller
public class IdentificationController {
  
  @PostMapping("/login")
  public String login(People people) {
    System.out.println(people);
    System.out.println(people.getUsername());
    return "login";
  }
}
