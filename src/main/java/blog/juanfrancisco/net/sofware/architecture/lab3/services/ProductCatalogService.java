package blog.juanfrancisco.net.sofware.architecture.lab3.services;

import blog.juanfrancisco.net.sofware.architecture.lab3.models.Product;

public interface ProductCatalogService {

    public void addProduct(String productnumber, String description, double price);

    public Product getProduct(String productnumber);

    public void setStock(String productnumber, int quantity, String locationcode);

}
