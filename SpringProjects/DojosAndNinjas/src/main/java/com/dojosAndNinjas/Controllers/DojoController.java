package com.dojosAndNinjas.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojosAndNinjas.Models.Dojo;
import com.dojosAndNinjas.Services.dojosAndNinjasService;

@Controller
@RequestMapping("/dojo")
public class DojoController {

	@Autowired
	private dojosAndNinjasService njService;
	
	@GetMapping("/new")
	public String createDojo(@ModelAttribute ("dojo") Dojo dojo) {
		return "dojoNew.jsp";
	}
	
	@PostMapping("/createDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {    //this is for good practice
			return "dojoNew.jsp";
		}
		this.njService.createDojo(dojo);
		return "redirect:/ninja/new"; //routing to create ninja after dojo creation
	}
	
	@GetMapping("/{id}")
	public String showDojo(Model viewModel, @PathVariable("id")Long id) {
		viewModel.addAttribute("dojo", this.njService.getOneDojo(id));
		return "showDojo.jsp";
	}
}
