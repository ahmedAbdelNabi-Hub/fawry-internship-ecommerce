package domain.Entities;

import domain.Abstract.Product;
import domain.interfaces.IShippable;

public class ShippableProduct extends Product implements IShippable {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }


    public double getWeight() {
        return weight;
    }


    @Override
    public boolean isShipping() {
        return true;
    }


    @Override
    public boolean canExpire() {
        return false;
    }
    
}
