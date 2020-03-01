package blog.juanfrancisco.net.sofware.architecture.lab3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {
	@Id
	private String productNumber;
	private double price;
	private String description;
	private Stock stock;

	public Product(String productNumber, String description, double price) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.description = description;
	}


}
