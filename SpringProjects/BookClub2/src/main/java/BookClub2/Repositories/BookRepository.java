package BookClub2.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BookClub2.Models.BookModel;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {

	//get all books
	List<BookModel> findAll();
	
}
