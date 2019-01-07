package wolox.training.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting "+name;
    }

    @RequestMapping("/create")
    @PostMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book ) {
        return bookRepository.save(book);
    }

    @GetMapping("/view")
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/")
    public Iterable<Book> findBooks(@RequestParam(name="bookTitle", required=false, defaultValue="") String bookTitle,
                                    @RequestParam(name="author", required=false, defaultValue="") String author,
                                    @RequestParam(name="isbn", required=false, defaultValue="") String isbn) {
        System.out.println(bookTitle);
        return bookRepository.findByAuthorContainingAndTitleContainingAndIsbnContainingAllIgnoreCase(author, bookTitle, isbn);
    }

    @GetMapping("/view/{id}")
    public Book findById(@PathVariable long id){
        return bookRepository.findById(id);
    }


    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}