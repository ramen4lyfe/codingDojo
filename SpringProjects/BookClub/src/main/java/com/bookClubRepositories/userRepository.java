package com.bookClubRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookClubModels.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	Optional<User> findByEmail(String email);	
	
}
