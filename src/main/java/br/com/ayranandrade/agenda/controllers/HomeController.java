/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ayranandrade.agenda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ayran
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        System.out.println("aqui 1");
        return "home";
    }
}
