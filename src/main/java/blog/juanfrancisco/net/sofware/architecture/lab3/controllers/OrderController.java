package blog.juanfrancisco.net.sofware.architecture.lab3.controllers;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Order;
import blog.juanfrancisco.net.sofware.architecture.lab3.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order/checkout/{shopingCartId}/{orderId}")
    public ResponseEntity<?> getGreeting(@PathVariable("orderId") String orderId, @PathVariable("shopingCartId") String shopingCartId) {

        this.orderService.createOrder(orderId, shopingCartId);
        return new ResponseEntity<String>("ok", HttpStatus.OK);


    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable("orderId") String orderId) {

        return new ResponseEntity<Order>(this.orderService.getOrder(orderId), HttpStatus.OK);


    }

}
