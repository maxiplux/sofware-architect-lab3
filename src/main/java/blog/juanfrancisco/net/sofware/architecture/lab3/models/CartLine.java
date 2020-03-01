package blog.juanfrancisco.net.sofware.architecture.lab3.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CartLine {

    private Product product;
    private int quantity;


}
