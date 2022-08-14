package com.BookClub1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.BookClub1.models.Book;
import com.BookClub1.models.User;
import com.BookClub1.services.bookService;
import com.BookClub1.services.userService;

@Controller
public class homeController {

	@Autowired
    private userService users;
    @Autowired
    private bookService books;
    
    // dashboard info. 
    @GetMapping("/welcome")
    public String home(Model model, HttpSession session) {
    	
    	//check user in session, if not redirect to root. If user is in session, shows book library
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}    	
    	model.addAttribute("books", books.all());
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "welcomeUser.jsp";
    }
    
    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);    	
    	return "addBook.jsp";
    }
    
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

    	if (result.hasErrors()) {
    		return "addBook.jsp";
    	}    	
    	books.create(book);    	
    	return "redirect:/home";
    }
    
    @GetMapping("/books/{id}/edit")
    public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}    	
    	Book book = books.findById(id);
    	model.addAttribute("book", book);    	
    	return "editEntry.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Book book = books.findById(id);
    	model.addAttribute("book", book);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "showEntry.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    	
    	if (result.hasErrors()) {
    		return "editPage.jsp";
    	}    	
        books.update(book);    	
    	return "redirect:/welcome";
    }
}
