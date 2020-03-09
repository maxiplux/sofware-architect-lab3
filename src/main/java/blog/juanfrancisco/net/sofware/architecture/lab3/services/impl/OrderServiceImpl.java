package blog.juanfrancisco.net.sofware.architecture.lab3.services.impl;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Order;
import blog.juanfrancisco.net.sofware.architecture.lab3.models.ShoppingCart;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.OrderRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.repositories.ShoppingCartRepository;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public void createOrder(String orderId, ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderId(orderId);

        shoppingCart.getItems().forEach(item -> {
            order.addToCart(item.getProduct(), item.getQuantity());
        });
        this.orderRepository.save(order);


    }

    @Override
    public Order getOrder(String orderId) {
        return this.orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Boolean createOrder(String orderId, String shopingCartId) {
        Optional<ShoppingCart> optionalShoppingCart = this.shoppingCartRepository.findById(shopingCartId);

        optionalShoppingCart.ifPresent(shoppingCart -> {
            createOrder(orderId, shoppingCart);
        });
        return optionalShoppingCart.isPresent();
    }

    @Override
    public Boolean createOrder(String shopingCartId) {
        Order order = new Order();
        order = this.orderRepository.save(order);
        Optional<ShoppingCart> optionalShoppingCart = this.shoppingCartRepository.findById(shopingCartId);

        if (optionalShoppingCart.isPresent()) {
            this.createOrder(order.getOrderId(), optionalShoppingCart.get());
            return true;
        }
        return false;


    }
}
