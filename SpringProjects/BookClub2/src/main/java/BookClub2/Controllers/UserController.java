package BookClub2.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import BookClub2.Models.LoginUser;
import BookClub2.Models.UserModel;
import BookClub2.Services.BookService;
import BookClub2.Services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired BookService bookService;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") UserModel user, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}
	
	//register user
	@PostMapping("/register")
	public String registerUser(
			@Valid @ModelAttribute("newUser") UserModel user, 
			BindingResult result, 
			HttpSession session, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		
		//validate user
		userService.validateUser(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		//actually register the user
		userService.registerUser(user);
		
		// put the user in session
		// I'm putting the entire user object in session here
		session.setAttribute("loggedInUser", user);
		return "redirect:/welcome";
	}
	
	// login user
	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
			BindingResult result, //note: always have Bindingresults to what I'm @Validating. otherwise errors will not show up
			HttpSession session, 
			@ModelAttribute("newUser") UserModel user) {
		
		//authenticate user
		userService.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		UserModel loggedInUser=userService.findByEmail(loginUser.getEmail());
		
		//put user in session 
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/welcome";
				
	}
	
	//logout
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

