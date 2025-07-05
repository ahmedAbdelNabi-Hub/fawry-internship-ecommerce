package domain.Entities;
import java.util.ArrayList;
import java.util.List;
import domain.Abstract.Product;
import domain.Exceptions.NotEnoughStockException;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (quantity > product.getQuantity())
            throw new NotEnoughStockException(product.getName(), product.getQuantity(), quantity);
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.product.getPrice() * item.quantity;
        }
        return total;
    }

}
