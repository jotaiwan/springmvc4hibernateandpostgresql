package com.spittr.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import com.spittr.data.JdbcSpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spittr.dto.Spitter;
import com.spittr.data.JdbcSpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

//  @Autowired
  private JdbcSpitterRepository spitterRepository;

  public SpitterController() {
  }

  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm() {
    return "registerForm";
  }

  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @Valid Spitter spitter,
      Errors errors) {
    if (errors.hasErrors()) {
      return "registerForm";
    }

    spitterRepository.save(spitter);
    return "redirect:/spitter/" + spitter.getUsername();
  }

  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUsername(username);
    model.addAttribute(spitter);
    return "profile";
  }

}
