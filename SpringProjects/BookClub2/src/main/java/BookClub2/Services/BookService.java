package BookClub2.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookClub2.Models.BookModel;
import BookClub2.Repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// find book by ID
	public BookModel findById( Long id ) {
		Optional<BookModel> bookResult = bookRepo.findById(id);
		if(bookResult.isPresent()) {
			return bookResult.get();
		}
		return null;
	}
	
	// Get all books
	public List<BookModel> getAllBooks(){
		return bookRepo.findAll();
	}
	
	
	// create new book entry
	public BookModel createBook(BookModel newCreatedBook) {
		return bookRepo.save(newCreatedBook);
	}
	
	
	// Update book entry
	public BookModel updateBook(BookModel updatedBook) {
		return bookRepo.save(updatedBook);
	}
	
	
	// Delete book by id
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
		
	// Book details
	public BookModel bookDetails(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
}
