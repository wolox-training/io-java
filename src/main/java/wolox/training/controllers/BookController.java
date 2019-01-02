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
    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @RequestMapping("/save")
    public String process(){
        //Only for testing
        bookRepository.save(new Book ("Title", "Author","Image",
                                        "Subtitle", "Publisher", "year", 2, "isbn"));
        return "Done";
    }

    @RequestMapping("/test")
    public String test(@RequestParam("title") String title){
        System.out.println(title);
        //Only for testing
        bookRepository.save(new Book (title, "Author","Image",
                "Subtitle", "Publisher", "year", 2, "isbn"));
        return title;
    }

    @RequestMapping("/create")
    @PostMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book ) {
        return bookRepository.save(book);
    }

    @GetMapping("/title/{bookTitle}")
    public Optional<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Optional<Book> findOne(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        bookRepository.findById(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id);
        bookRepository.deleteById(id);
    }
}