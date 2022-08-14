package TvShows.Controllers;

import javax.servlet.http.HttpSession;
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

import TvShows.Models.TvShowModel;
import TvShows.Services.TvShowService;
import TvShows.Services.UserService;

@Controller
public class TvShowController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TvShowService tvShowService;
	
	@GetMapping("/shows")
	public String welcome(Model model, HttpSession session) {
		// check if user is in session or not. do this for every login page
		// if user is not in session. don't allow them to see content but redirect them to login or register
		if(session.getAttribute("loggedInUser")==null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("tvShows", tvShowService.getAllShows());
			return "welcomeUser.jsp";
		}
	}
	
	// Create show 
	@GetMapping("/shows/new")
	public String addBook(@ModelAttribute("newShow") TvShowModel show, Model model, HttpSession session) {
		
		if(session.getAttribute("loggedInUser") == null) {
    		return "redirect:/";
    	}
		else {  
	    	return "addShow.jsp";
		}	
	}

	@PostMapping("/create")
    public String createBook(@Valid @ModelAttribute("newShow") TvShowModel show, BindingResult result) {
    	if (result.hasErrors()) {
    		return "addShow.jsp";
    	} 
    	else {
    		tvShowService.createShow(show);    	
	    	return "redirect:/shows";
    	}
    }
	
	// show details
		@GetMapping("/shows/{id}/details")
		public String bookDetails(Model model, @PathVariable("id") Long id, HttpSession session) {		
			if(session.getAttribute("loggedInUser") == null) {
	    		return "redirect:/";
	    	}
			else {
				model.addAttribute("show", tvShowService.showDetails(id));
		    	return "showDetails.jsp";
			}
		}
	
	// edit show
	@GetMapping("/shows/{id}/edit")
 	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		 if(session.getAttribute("loggedInUser") == null) {
	    		return "redirect:/";
	    	}
		 else {
			 TvShowModel show = tvShowService.findById(id);
			 model.addAttribute("editShow", tvShowService.showDetails(id));
			 return "editShow.jsp";
		 }
	 }
	
	//update entry
	@PutMapping("/shows/{id}/update")
	public String updateBook(@Valid @ModelAttribute("editShow") TvShowModel show, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editShow.jsp";
		}
			else {
				tvShowService.updateShow(show);
			return "redirect:/shows";
		}
	}

	//delete show
	@DeleteMapping("/shows/{id}/delete")
	public String deleteShow(@PathVariable("id") Long id) {
		TvShowModel show = tvShowService.findById(id);
		tvShowService.deleteShow(id);
		return "redirect:/shows";
	}
	
	


}
