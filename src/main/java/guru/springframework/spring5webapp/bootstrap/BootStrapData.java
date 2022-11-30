package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher einaudi = new Publisher();
        einaudi.setName("Einaudi");
        einaudi.setCity("Torino");
        einaudi.setAddressLine1("Via Biancamano, 2");
        einaudi.setZip("10121");

        publisherRepository.save(einaudi);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author saramago = new Author("Jose", "Saramago");
        Book blindness = new Book("Blindness", "98738");
        saramago.getBooks().add(blindness);
        blindness.getAuthors().add(saramago);

        blindness.setPublisher(einaudi);
        einaudi.getBooks().add(blindness);

        authorRepository.save(saramago);
        bookRepository.save(blindness);
        publisherRepository.save(einaudi);

        Author melville = new Author("Herman", "Melville");
        Book mobyDick = new Book("Moby Dick", "12312");
        melville.getBooks().add(mobyDick);
        mobyDick.getAuthors().add(melville);

        mobyDick.setPublisher(einaudi);
        einaudi.getBooks().add(mobyDick);

        authorRepository.save(melville);
        bookRepository.save(mobyDick);
        publisherRepository.save(einaudi);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Published Books: " + einaudi.getBooks().size());
    }
}
