package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.SaveTravels2.models.Expense;
import com.languages.models.Language;
import com.languages.services.LanguageService;

@Controller
public class MainController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/")
		public String index() {
			return "redirect:/languages";
	}
	
	@GetMapping("/languages")
		public String languages(@ModelAttribute("language") Language expense, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);	
		return "index.jsp";
	}
	
	@GetMapping("/edit{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			model.addAttribute("language", languageService.find(id));
			return "edit.jsp";
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.find(id));
		System.out.println("this is the platform solution.");
		return "show.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languageService.all());
			return "index.jsp";
		}
		System.out.println("this is the platform solution.");
		languages.create(language);
		return "redirect:/languages";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("languages", languageService.all());
			return "edit.jsp";
		}
		languages.update(language);	
		return "redirect:/languages";
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		languages.delete(id);
		return "redirect:/languages";
	}
}
