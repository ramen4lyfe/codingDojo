// this model is to be used for validating input from the login form

/*
we will never save LoginUser object instances to the database. 
Rather, we will use this new class as an input validator 
using the form helper tags we've been using for model-level validations.

This is why this model does not have @Entity annotation,
and it only has email and password as those are the fields a user must fill in to log into our app.
 */

package authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    //generating getters and setters
    
}
