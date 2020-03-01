package blog.juanfrancisco.net.sofware.architecture.lab3.repositories;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {

}
