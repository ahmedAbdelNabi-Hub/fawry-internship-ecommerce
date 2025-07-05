package domain.Entities;

import java.util.ArrayList;
import java.util.List;
import domain.Abstract.Product;
import domain.Exceptions.ExpiredProductException;
import domain.Exceptions.NotEnoughStockException;
import domain.interfaces.IExpirable;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (product.canExpire() && ((IExpirable) product).isExpired()) {
            throw new ExpiredProductException(product.getName());
        }
        if (quantity > product.getQuantity()) {
            throw new NotEnoughStockException(product.getName(), product.getQuantity(), quantity);
        }
        items.add(new CartItem(product, quantity));
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
