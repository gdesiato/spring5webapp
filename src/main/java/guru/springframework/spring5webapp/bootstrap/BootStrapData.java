package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author saramago = new Author("Jose", "Saramago");
        Book blindness = new Book("Blindness", "98738");
        saramago.getBooks().add(blindness);
        blindness.getAuthors().add(saramago);

        authorRepository.save(saramago);
        bookRepository.save(blindness);

        Author melville = new Author("Herman", "Melville");
        Book moby = new Book("Moby Dick", "12312");
        melville.getBooks().add(moby);
        moby.getAuthors().add(melville);

        authorRepository.save(melville);
        bookRepository.save(moby);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
