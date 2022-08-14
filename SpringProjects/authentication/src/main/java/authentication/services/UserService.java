package authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import authentication.models.LoginUser;
import authentication.models.User;
import authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepo;
	
    // TO-DO: Write register and login methods!
	
	// This method will be called from the controller
    // whenever a user submits a registration form.
	public User register(User newUser, BindingResult result) {
       // TO-DO: Additional validations!
    	Optional<User> potentialUser = UserRepo.findByEmail(newUser.getEmail());

		if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return UserRepo.save(newUser);
    	
    }
	
	
	public User login(LoginUser newLogin, BindingResult result) {
	   // TO-DO: Additional validations!
		
		Optional<User> potentialUser = UserRepo.findByEmail(newLogin.getEmail());
        
    	// Find user in the DB by email
        // Reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	// User exists, retrieve user from DB
    	User user = potentialUser.get();
        
        // Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        // Otherwise, return the user object
        return user;
    }
	
	 public User findById(Long id) {
	    	Optional<User> potentialUser = UserRepo.findById(id);
	    	if(potentialUser.isPresent()) {
	    		return potentialUser.get();
	    	}
	    	return null;
	    }
    	
    
}
