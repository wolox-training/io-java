package wolox.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wolox.training.models.Book;
import org.springframework.data.repository.*;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByAuthorContainingAndTitleContainingAndIsbnContainingAllIgnoreCase(String author, String title, String isbn);
    Optional<Book> findByIsbn(String isbn);
    Book findById(long id);
}