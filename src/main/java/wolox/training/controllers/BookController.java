package wolox.training.controllers;

import wolox.training.DAO.BookDAO;
//import wolox.training.exceptions.BookDoesNotExistException;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;
//import wolox.training.services.OpenLibraryService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

//@Controller
@RequestMapping("/api/books")
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //private OpenLibraryService onlineLibrary = new OpenLibraryService();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        System.out.println(name);
        model.addAttribute("name", name);
        return "greeting " + name;
    }

    @GetMapping(value = {"/", ""})
    public String home() {
        return "home";
    }

    // Create
    @RequestMapping("/create")
    @PostMapping("/books/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book ) {
        return bookRepository.save(book);
    }

    // Read
    @GetMapping("/view")
    public Iterable findAll() {
        return bookRepository.findAll();
    }






}