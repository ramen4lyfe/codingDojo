package com.BookClub1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookClub1.models.Book;

@Repository
public interface bookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

}
