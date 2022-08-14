package TvShows.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import TvShows.Models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long> {
	List<UserModel> findAll();
	
	UserModel findByEmail(String email);
}
