package com.bookClubRepositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookClubModels.Book;

@Repository
public interface bookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

}
