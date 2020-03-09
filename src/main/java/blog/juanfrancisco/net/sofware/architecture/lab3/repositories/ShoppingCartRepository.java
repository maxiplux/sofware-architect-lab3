package blog.juanfrancisco.net.sofware.architecture.lab3.repositories;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
