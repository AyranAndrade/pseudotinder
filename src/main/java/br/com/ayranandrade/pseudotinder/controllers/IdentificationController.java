package br.com.ayranandrade.pseudotinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ayran
 */
@Controller
public class IdentificationController {
  
  @PostMapping("/login")
  public String login(@RequestParam String username) {
    System.out.println(username);
    return "login";
  }
}
