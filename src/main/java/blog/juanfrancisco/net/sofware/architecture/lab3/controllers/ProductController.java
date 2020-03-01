package blog.juanfrancisco.net.sofware.architecture.lab3.controllers;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
	@Autowired
	private ProductCatalogService productCatalogService;

	@GetMapping("/product/{productnumber}")
	public ResponseEntity<?> getProduct(@PathVariable String productnumber) {
		Product product = productCatalogService.getProduct(productnumber);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(value = "/product/")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		productCatalogService.addProduct(product.getProductNumber(), product.getDescription(), product.getPrice());
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{productNumber}/stock/{quantity}/{locationcode}", method = RequestMethod.PATCH)
	public ResponseEntity<?> setStock(@PathVariable String productNumber, @PathVariable int quantity, @PathVariable String locationcode) {
		productCatalogService.setStock(productNumber, quantity, locationcode);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
