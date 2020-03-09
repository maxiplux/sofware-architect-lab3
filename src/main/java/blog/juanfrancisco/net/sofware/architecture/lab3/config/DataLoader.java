package blog.juanfrancisco.net.sofware.architecture.lab3.config;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Book;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.Stock;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.BookRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.createBooks();
        this.createProducts();

    }

    private void createProducts() {
        Product product = new Product("100", "p1", 100);
        product.setStock(new Stock(10, "A1"));


        Product product2 = new Product("200", "p2", 100);
        product2.setStock(new Stock(10, "A2"));

        product2.setDescription("proc2");
        this.productRepository.save(product);
        this.productRepository.save(product2);


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
