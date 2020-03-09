package blog.juanfrancisco.net.sofware.architecture.lab3.services.impl;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.ProductRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.ShoppingCartRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public void addToCart(String cartId, String productnumber, int quantity) {
		Optional<Product> product = productRepository.findById(productnumber);

		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent()) {
			cartOptional.ifPresent(cart -> {


				cart.addToCart(product.get(), quantity);

				shoppingCartRepository.save(cart);

			});
		} else {
			ShoppingCart cart = new ShoppingCart();
			cart.setShoppingId(cartId);
			cart.addToCart(product.get(), quantity);
			shoppingCartRepository.save(cart);

		}


	}

	@Override
	public void checkOut(String cartId) {

		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);

	}

	@Override
	public ShoppingCart getCart(String cartId) {
		return shoppingCartRepository.findById(cartId).orElse(null);

	}

	@Override
	public ShoppingCart createCart(ShoppingCart shoppingCart) {

		return this.shoppingCartRepository.save(shoppingCart);
	}
}
