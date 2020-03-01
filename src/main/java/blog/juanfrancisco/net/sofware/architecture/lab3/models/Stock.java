package blog.juanfrancisco.net.sofware.architecture.lab3.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Stock {
    private int quantity;
    private String locationCode;

    public Stock(int quantity, String locationCode) {

        this.quantity = quantity;
        this.locationCode = locationCode;
    }

}
