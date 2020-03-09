package blog.juanfrancisco.net.sofware.architecture.lab3.services;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;

public interface ShoppingService {
    void addToCart(String cartId, String productnumber, int quantity);

    void checkOut(String cartId);

    ShoppingCart getCart(String cartId);

    ShoppingCart createCart(ShoppingCart shoppingCart);
}
