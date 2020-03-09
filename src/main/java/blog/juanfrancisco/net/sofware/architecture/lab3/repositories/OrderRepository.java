package blog.juanfrancisco.net.sofware.architecture.lab3.repositories;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
