package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*this annotation tells spring that we want make
 this class a Spring MVC controller
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    /*
    thanks to this constructor we are injecting an instance
    of the book repository into the controller
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //we want to map this to a specific URL
    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());


        return "books/list";
    }
}
