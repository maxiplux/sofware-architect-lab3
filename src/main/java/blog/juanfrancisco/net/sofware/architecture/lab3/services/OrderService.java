package blog.juanfrancisco.net.sofware.architecture.lab3.services;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Order;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;

public interface OrderService {
    public void createOrder(String orderId, ShoppingCart shoppingCart);

    public Order getOrder(String orderId);

    public Boolean createOrder(String orderId, String shopingCartId);

    Boolean createOrder(String shopingCartId);
}
