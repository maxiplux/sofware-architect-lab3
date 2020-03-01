package blog.juanfrancisco.net.sofware.architecture.lab3.services.impl;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.Stock;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.ProductRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
	@Autowired
	private ProductRepository productRepository;

	public void addProduct(String productnumber, String description, double price) {
		Product product = new Product(productnumber, description, price);
		this.productRepository.save(product);

	}

	public Product getProduct(String productnumber) {
		Optional<Product> result = this.productRepository.findById(productnumber);
		if (result.isPresent())
			return result.get();
		else
			return null;
	}

	public void setStock(String productnumber, int quantity, String locationcode) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		}
	}
}
