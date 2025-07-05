package domain.Entities;

import domain.Abstract.Product;

public class SimpleProduct extends Product {

    public SimpleProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isShipping() {
        return false;
    }

    @Override
    public boolean canExpire() {
        return false;
    }

}
