package com.dojosAndNinjas.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojosAndNinjas.Models.Dojo;
import com.dojosAndNinjas.Models.Ninja;
import com.dojosAndNinjas.Services.dojosAndNinjasService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	
	@Autowired
	private dojosAndNinjasService njService;
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Dojo> allDojos = this.njService.allDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "ninjaNew.jsp";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {    //this is for good practice
			
			List<Dojo> allDojos = this.njService.allDojos();
			viewModel.addAttribute("allDojos", allDojos);
			return "ninjaNew.jsp";
		}
		this.njService.createNinja(ninja);
		return "redirect:/dojo/" + ninja.getDojo().getId(); 
	}
}
