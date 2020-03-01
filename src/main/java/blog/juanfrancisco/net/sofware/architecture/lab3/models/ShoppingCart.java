package blog.juanfrancisco.net.sofware.architecture.lab3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Iterator;

@Document
@Data
public class ShoppingCart {
	ArrayList<CartLine> items = new ArrayList<CartLine>();
	@Id
	private String shoppingId;

	public void addToCart(Product product, int quantity) {
		for (CartLine item : items) {
			if (item.getProduct().getProductNumber().equals(product.getProductNumber())) {
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(quantity);
		items.add(cline);
	}


	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (CartLine cline : items) {
			totalPrice = totalPrice + (cline.getProduct().getPrice() * cline.getQuantity());
		}
		return totalPrice;
	}

	public void removeFromCart(Product product) {
		Iterator<CartLine> iter = items.iterator();
		while (iter.hasNext()) {
			CartLine cline = iter.next();
			if (cline.getProduct().getProductNumber().equals(product.getProductNumber())) {
				if (cline.getQuantity() > 1) {
					cline.setQuantity(cline.getQuantity() - 1);
				} else {
					iter.remove();
				}
			}
		}
	}


}
