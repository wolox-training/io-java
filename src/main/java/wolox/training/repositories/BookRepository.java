package wolox.training.repositories;

import org.springframework.data.jpa.repository.Query;
import wolox.training.models.Book;
import org.springframework.data.repository.*;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Integer> {

    Optional<Book> findByAuthor(String author);

}