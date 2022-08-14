//package com.bookClubControllers;
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
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
//import bookClubModels.Book;
//import bookClubModels.LoginUser;
//import bookClubModels.User;
//import bookClubServices.bookService;
//import bookClubServices.userService;

//@Controller
//public class bookController {
//
//	@Autowired
//    private userService users;
//    @Autowired
//    private bookService books;
 
//-------login controller--------
//   @GetMapping("/")
//   public String login(Model model) {
//
//       model.addAttribute("newUser", new User());
//       model.addAttribute("newLogin", new LoginUser());
//       return "login.jsp";
//   }
//   
//   @PostMapping("/register")
//   public String register(@Valid @ModelAttribute("newUser") User newUser, 
//           BindingResult result, Model model, HttpSession session) {
//
//   	User user = users.register(newUser, result);
//   	      
//       if(result.hasErrors()) {
//           model.addAttribute("newLogin", new LoginUser());
//           return "login.jsp";
//       }
//       //Store their ID in session
//       session.setAttribute("userId", user.getId());
//   
//       return "redirect:/welcome";
//   }
//   
//   @PostMapping("/login")
//   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
//           BindingResult result, Model model, HttpSession session) {
//       User user = users.login(newLogin, result);
//   
//       if(result.hasErrors()) {
//           model.addAttribute("newUser", new User());
//           return "login.jsp";
//       }
//       session.setAttribute("userId", user.getId());
//   
//       return "redirect:/welcome";
//   }
   
    
// -------welcomeUserController-----   
//   @GetMapping("/welcome")
//   public String welcome(Model model, HttpSession session) {
//   	
//   	if(session.getAttribute("userId") == null) {
//   		return "redirect:/";
//   	}
//   	
//   	model.addAttribute("books", books.all());
//   	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
//   	return "welcomeUser.jsp";
//   }
   
 
//-----addBookController-----
//   @GetMapping("/addPage")
//   public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session) {
//   	
//   	User user = users.findById((Long)session.getAttribute("userId"));
//   	model.addAttribute("user", user);
//   	
//   	return "addBook.jsp";
//   }
//   
//   @PostMapping("/books")
//   public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//
//   	if (result.hasErrors()) {
//   		return "addBook.jsp";
//   	}
//   	
//   	books.create(book);
//   	
//   	return "redirect:/welcome";
//   }
   
    
    
//--------editEntryController------    
//   @GetMapping("/books/{id}/edit")
//   public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
//   	
//   	if(session.getAttribute("userId") == null) {
//   		return "redirect:/";
//   	}
//   	
//   	Book book = books.findById(id);
//   	model.addAttribute("book", book);
//   	
//   	return "editEntry.jsp";
//   }
   
    
    
//------showEntryController----    
//   @GetMapping("/books/{id}")
//   public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
//   	
//	   if(session.getAttribute("userId") == null) {
//   		return "redirect:/";
//   	}
//   	
//	Book book = books.findById(id);
//   	model.addAttribute("book", book);
//   	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
//   	
//   	return "showEntry.jsp";
//   }
//   
//   @PutMapping("/books/{id}")
//   public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
//   	
//   	if (result.hasErrors()) {
//   		return "editEntry.jsp";
//   	}
//   	
//   	System.out.println("Book to be saved to DB: " + book.getId());
//
//       books.update(book);
//       
//   	
//   	return "redirect:/welcome";
//   }
   
//   @GetMapping("/logout")
//   public String logout(HttpSession session) {
//   	session.invalidate();
//   	return "redirect:/";
//   }
//}
