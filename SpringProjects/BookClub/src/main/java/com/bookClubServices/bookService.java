package com.bookClubServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookClubModels.Book;
import com.bookClubRepositories.bookRepository;

@Service
public class bookService {
	
	@Autowired
	private bookRepository repo;
	
	//
	public Book findById(Long id) {
		Optional<Book> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public List<Book> all() {
		return repo.findAll();
	}
	
	public Book update(Book book) {
		return repo.save(book);
	}
	
	public Book create(Book book) {
		return repo.save(book);
	}
	
	public void delete(Book book) {
		repo.delete(book);
	}
}
