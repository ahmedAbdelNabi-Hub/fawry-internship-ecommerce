package domain.Entities;

import domain.Abstract.Product;
import domain.interfaces.IShippable;

public class ShippableProduct extends Product implements IShippable {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String display() {
        return String.format("Shippable Product: %s, Price: %.2f, Quantity: %d, Weight: %.2f kg", getName(), getPrice(), getQuantity(), weight);
    }

    public double getWeight() {
        return weight;
    }
    
}
