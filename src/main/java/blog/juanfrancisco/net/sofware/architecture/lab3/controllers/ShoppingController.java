package blog.juanfrancisco.net.sofware.architecture.lab3.controllers;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;

	@PostMapping(value = "/cart/")
	public ResponseEntity<?> create(ShoppingCart shoppingCart) {

		return new ResponseEntity<ShoppingCart>(shoppingService.createCart(shoppingCart), HttpStatus.OK);
	}

	@PostMapping(value = "/cart/{cartId}/{productnumber}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId, @PathVariable String productnumber, @PathVariable int quantity) {
		// if you are checking it , sorry this is a homework I dont like this lines, but are instructions
		// i am writing it , because I like upload  each line of code to internet
		// sorry look at for other projects about spring in this repository
		shoppingService.addToCart(cartId, productnumber, quantity);
		return new ResponseEntity<ShoppingCart>(HttpStatus.OK);
	}

	@GetMapping("/cart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		ShoppingCart cart = shoppingService.getCart(cartId);

		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
	}

}
