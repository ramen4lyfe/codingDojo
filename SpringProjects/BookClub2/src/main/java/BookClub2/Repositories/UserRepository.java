package BookClub2.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BookClub2.Models.UserModel;

@Repository

public interface UserRepository extends CrudRepository <UserModel, Long> {

	//Get all user
	List<UserModel> findAll();
	
	UserModel findByEmail(String email);
	
	//get count query to set first user to be admin
	@Query(value = "SELECT COUNT (id) FROM users", nativeQuery = true)
	int getCount();
	
	
}
