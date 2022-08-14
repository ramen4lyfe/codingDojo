package TvShows.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class UserModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min=3, max=30, message="Username is required")
    private String userName;
    
    @NotBlank
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotBlank
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient //User Transient so confirm password does not get save to the DB
    @NotBlank
    @Size(min=8, max=128, message="Confirm password must match!")
    private String confirm;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
 // Establishing the relationship with the TvShowModel
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<TvShowModel> books;

    public UserModel() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<TvShowModel> getBooks() {
		return books;
	}

	public void setBooks(List<TvShowModel> books) {
		this.books = books;
	}

    
}
