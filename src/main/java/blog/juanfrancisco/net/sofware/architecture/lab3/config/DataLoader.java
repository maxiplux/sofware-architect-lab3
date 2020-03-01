package blog.juanfrancisco.net.sofware.architecture.lab3.config;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Book;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {
    @Autowired
    private BookRepository bookRepository ;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.createBooks();
    }

    private void createBooks() {
        Book book1 = new Book();
        book1.setIsbn("123");
        book1.setTitle("Book 1");
        book1.setAuthor("James Brawn");

        Book book2 = new Book();
        book2.setIsbn("124");
        book2.setTitle("Book 2");
        book2.setAuthor("Mary  Jones");

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);


    }
}
