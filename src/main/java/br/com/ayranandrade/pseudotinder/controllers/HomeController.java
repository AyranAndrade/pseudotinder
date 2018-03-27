package br.com.ayranandrade.pseudotinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController is responsible to serve the entry point from application.
 * @author Ayran
 */
@Controller
public class HomeController {
    
  @RequestMapping("/")
  public String home() {
    return "home";
  }
}
