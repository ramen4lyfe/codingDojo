package BookClub2.Controllers;

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
import BookClub2.Models.BookModel;
import BookClub2.Models.UserModel;
import BookClub2.Services.BookService;
import BookClub2.Services.UserService;

@Controller

public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		// check if user is in session or not. do this for every login page
		// if user is not in session. don't allow them to see content but redirect them to login or register
		if(session.getAttribute("loggedInUser")==null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("books", bookService.getAllBooks());
			return "welcomeUser.jsp";
		}
	}
	
// Create book 
	@GetMapping("/create/book")
	public String addBook(@ModelAttribute("newBook") BookModel book, Model model, HttpSession session) {
		
		if(session.getAttribute("loggedInUser") == null) {
    		return "redirect:/";
    	}
		else {  
	    	return "addBook.jsp";
		}	
	}
	
	 @PostMapping("/create")
	    public String createBook(@Valid @ModelAttribute("newBook") BookModel book, BindingResult result) {
	    	if (result.hasErrors()) {
	    		return "addBook.jsp";
	    	} 
	    	else {
		    	bookService.createBook(book);    	
		    	return "redirect:/welcome";
	    	}
	    }
	 
// show each book details
	@GetMapping("/books/{id}/details")
	public String bookDetails(Model model, @PathVariable("id") Long id, HttpSession session) {		
		if(session.getAttribute("loggedInUser") == null) {
    		return "redirect:/";
    	}
		else {
			model.addAttribute("books", bookService.bookDetails(id));
	    	return "bookDetails.jsp";
		}
	}
	 
// edit entry
	@GetMapping("/books/{id}/edit")
 	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		 if(session.getAttribute("loggedInUser") == null) {
	    		return "redirect:/";
	    	}
		 else {
			 BookModel book = bookService.findById(id);
			 model.addAttribute("editBook", bookService.bookDetails(id));
			 return "editEntry.jsp";
		 }
	 }

	//update entry
	@PutMapping("/books/{id}/update")
	public String updateBook(@Valid @ModelAttribute("editBook") BookModel book, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editEntry.jsp";
		}
			else {
			bookService.updateBook(book);
			return "redirect:/welcome";
		}
	}
}
