package br.com.ayranandrade.pseudotinder.controllers;

import br.com.ayranandrade.pseudotinder.models.People;
import br.com.ayranandrade.pseudotinder.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ayran
 */
@Controller
public class LoginController {
  
  @Autowired
  private PeopleService peopleService;
  
  @PostMapping("/login")
  public String login(@RequestParam String username) {
    People user = peopleService.findPeopleByUsername(username);
    System.out.println(username);
    return "login";
  }
}
