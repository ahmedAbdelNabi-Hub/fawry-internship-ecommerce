package domain.Entities;

import domain.Abstract.Product;

public class SimpleProduct extends Product {

    public SimpleProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String display() {
        return String.format("Simple Product: %s, Price: %.2f, Quantity: %d", getName(), getPrice(), getQuantity());
    }

}
