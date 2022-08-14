package com.BookClub1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookClub1.models.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	Optional<User> findByEmail(String email);	
	
}
