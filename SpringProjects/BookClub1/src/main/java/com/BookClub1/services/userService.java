package com.BookClub1.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.BookClub1.models.LoginUser;
import com.BookClub1.models.User;
import com.BookClub1.repositories.userRepository;

@Service
public class userService {
	
	@Autowired
	private userRepository repo;
	
    @Autowired
    private userRepository userRepo;

    public User register(User newUser, BindingResult result) {

        // Check if email is present
    	Optional<User> userLookUp = userRepo.findByEmail(newUser.getEmail());
    	if (userLookUp.isPresent()) {
    		result.rejectValue("email", "Unique", "This email already exists.");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "Password must match!");
    	}
        
        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	newUser = repo.save(newUser);
    	System.out.println("New user created with ID: " + newUser.getId());
    	
        return newUser;
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
        
    	// Find user in the DB by email
        // Reject if NOT present
    	Optional<User> userLookUp = userRepo.findByEmail(newLogin.getEmail());
    	if (!userLookUp.isPresent()) {
    		result.rejectValue("email", "MissingAccount", "No account found.");
    		return null;
    	}
    	// User exists, retrieve user from DB
    	User user = userLookUp.get();
        
        // Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	return user;
    }

	public User findByEmail(String email) {
		
		Optional<User> result = repo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}		
		return null;
	}
	
	public User findById(Long id) {
		
		Optional<User> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
}