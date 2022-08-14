package com.bookClubControllers;
//package bookClubControllers;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import bookClubModels.LoginUser;
//import bookClubModels.User;
////import bookClubServices.bookService;
//import bookClubServices.userService;
//
//@Controller
//public class loginController {
//
//	@Autowired
//    private userService users;
////    @Autowired
////    private bookService books;
//    
//    @GetMapping("/")
//    public String login(Model model) {
//        model.addAttribute("newUser", new User());
//        model.addAttribute("newLogin", new LoginUser());
//        return "login.jsp";
//    }
//    
//    @PostMapping("/register")
//    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
//
//    	User user = users.register(newUser, result);
//    	      
//        if(result.hasErrors()) {
//            model.addAttribute("newLogin", new LoginUser());
//            return "login.jsp";
//        }
//        //Store their ID in session
//        session.setAttribute("userId", user.getId());
//    
//        return "redirect:/welcome";
//    }
//    
//    @PostMapping("/login")
//    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
//    	
//    	User user = users.login(newLogin, result);
//    
//        if(result.hasErrors()) {
//            model.addAttribute("newUser", new User());
//            return "login.jsp";
//        }
//        session.setAttribute("userId", user.getId());
//    
//        return "redirect:/welcome";
//    }
//    
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//    	session.invalidate();
//    	return "redirect:/";
//    }
//}
