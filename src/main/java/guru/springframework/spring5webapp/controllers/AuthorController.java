package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    /*
    thanks to this constructor we are injecting an instance
    of the book repository into the controller
     */
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //create a method to handle requests for authors
    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
