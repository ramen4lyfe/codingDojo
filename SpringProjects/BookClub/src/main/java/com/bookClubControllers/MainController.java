package com.bookClubControllers;

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

import com.bookClubModels.Book;
import com.bookClubModels.LoginUser;
import com.bookClubModels.User;
import com.bookClubServices.bookService;
import com.bookClubServices.userService;

@Controller
public class MainController {

	// Add once service is implemented:
     @Autowired
     private userService users;
     @Autowired
     private bookService books;
    
    @GetMapping("/")
    public String login(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // Call a register method in the service 
        // to do some extra validations and create a new user!
    	User user = users.register(newUser, result);
    	
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
    
        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = users.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
    
        // No errors! 
        // Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
    
        return "redirect:/welcome";
    }
    
    @GetMapping("/welcome")
    public String home(Model model, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/login";
    	}
    	
    	model.addAttribute("books", books.all());
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "welcomeUser.jsp";
    }
    
    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
    	
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
    	return "addshowEntry.jsp";
    }
    
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

    	if (result.hasErrors()) {
    		return "addshowEntry.jsp";
    	}
    	
    	books.create(book);
    	
    	return "redirect:/welcome";
    }
    
    @GetMapping("/books/{id}/edit")
    public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/login";
    	}
    	
    	Book book = books.findById(id);
    	model.addAttribute("book", book);
    	
    	return "editEntry.jsp";
    }
    @GetMapping("/books/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/login";
    	}
    	Book book = books.findById(id);
    	model.addAttribute("book", book);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	
    	return "showEntry.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    	
    	if (result.hasErrors()) {
    		return "editEntry.jsp";
    	}
    	
    	System.out.println("Book to be saved to DB: " + book.getId());

        books.update(book);
        
    	
    	return "redirect:/welcome";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
    
}