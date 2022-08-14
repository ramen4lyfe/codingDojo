package TvShows.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import TvShows.Models.LoginUser;
import TvShows.Models.UserModel;
import TvShows.Repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//Hash users pw and add to database
	public UserModel registerUser(UserModel newUser) {
		String hashedPass=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt()); // this line of code give me the hashed pw using BCRYPT
		newUser.setPassword(hashedPass); // this line of code replaces the user's pw with the hashed pw
		userRepo.save(newUser); // this line of code save the new hashed pw to the DB
		return null;
	}
	
	//Get All user
	public List<UserModel> getAllUser(){
		return userRepo.findAll();
	}
	
	// Create New User
	public UserModel createUser(UserModel newCreatedUser) {
		return userRepo.save(newCreatedUser);
	}
		
	//validate user for duplicate email and pw not match
	public void validateUser(UserModel newUser, Errors errors) {
		
		//password matching
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			errors.rejectValue("password","Mismastch","Password does not match!");
		}
		//email duplicate
		if(userRepo.findByEmail(newUser.getEmail())!=null) {
			errors.rejectValue("email", "unique","Email already exist!");
		}
		
	}
	
	//find user by email at login form
	public UserModel findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	//find user by id
	public UserModel findById(Long id) {
		Optional<UserModel> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	
	}
	
	//user authentication for login form 
	//first we find user by email
	// if we can't find user by email , return false
	// if user is found, check if pw match, return true, else false
	public boolean authenticateUser(LoginUser newLogin, Errors errors) {
		
		UserModel user = userRepo.findByEmail(newLogin.getEmail());
		if(user==null) {
			errors.rejectValue("email","missingEmail","Email not found!");
			return false;
		}
		else {
			if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
				errors.rejectValue("password","Matches","Invalid Password!");
			return false;
			}
		}
		return true;
	}
	
}
