package domain.Entities;

import java.time.LocalDate;
import domain.Abstract.Product;
import domain.interfaces.IExpirable;
import domain.interfaces.IShippable;

public class ExpirableShippableProduct extends Product implements IExpirable, IShippable {
    private LocalDate expiryDate;
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
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
        return true;
    }
}
