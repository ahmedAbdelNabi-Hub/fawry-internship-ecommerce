package domain.Entities;
import java.time.LocalDate;
import domain.Abstract.Product;
import domain.interfaces.IExpirable;
import domain.interfaces.IShippable;

public class ExpirableShippableProduct extends Product implements IExpirable , IShippable {

    private LocalDate expiryDate;
    private double weight;

    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public String display() {
        return String.format("Expirable Product: %s, Price: %.2f, Quantity: %d, Expiry Date: %s, Weight: %.2f kg",
                getName(), getPrice(), getQuantity(), expiryDate, weight);
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

}
