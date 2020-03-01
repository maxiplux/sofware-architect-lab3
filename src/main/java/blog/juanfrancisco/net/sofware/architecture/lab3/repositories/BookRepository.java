package blog.juanfrancisco.net.sofware.architecture.lab3.repositories;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BookRepository  extends  MongoRepository<Book,String> {

}
