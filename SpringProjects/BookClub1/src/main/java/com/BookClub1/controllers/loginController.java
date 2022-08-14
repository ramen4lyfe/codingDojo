package com.BookClub1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.BookClub1.models.LoginUser;
import com.BookClub1.models.User;
import com.BookClub1.services.userService;

@Controller
public class loginController {

   @Autowired
   private userService users;
   
   @GetMapping("/")
   public String index(Model model) {

       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "login.jsp";
   }
   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	   User user = users.register(newUser, result);
       
	   if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "login.jsp";
       }
       //Store in session
       session.setAttribute("userId", user.getId()); 
       return "redirect:/welcome";
   }
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = users.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "login.jsp";
       }
       session.setAttribute("userId", user.getId());
       return "redirect:/welcome";
   }
   
   @PostMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();
	   return "redirect:/";
   }
}
