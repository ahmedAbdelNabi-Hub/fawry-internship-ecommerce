package Service;

import java.util.ArrayList;
import java.util.List;

import domain.Entities.Cart;
import domain.Entities.CartItem;
import domain.Entities.Customer;
import domain.Exceptions.EmptyCartException;
import domain.Exceptions.NotEnoughMoneyException;
import domain.interfaces.IShippable;
import domain.interfaces.services.ICheckoutService;
import domain.interfaces.services.IShippingService;

public class CheckoutService implements ICheckoutService {
    //  محاكاة الـ Dependency Injection:
    // أنا عامل السطر ده كنوع من المحاكاة لفكرة الـ Dependency Injection اللي بتحصل في Spring / .NET Core
    // بحيث بدل ما أعمل new جوه الكلاس، أستقبل الـ dependency (ShippingService) من بره
    // وده بيخليني أقدر أختبر الكود بسهولة، أو أغير الطريقة اللي بشحن بيها من غير ما أعدل في الكود ده
    // وذكرت ده كمان في ملف الـ README علشان اللي يقرا الكود يفهم ليه استخدمت الأسلوب ده
   
    private IShippingService shippingService;
    public CheckoutService(IShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        List<CartItem> items = cart.getItems();
        List<IShippable> shippableItems = getShippableItems(cart);

        if (items.isEmpty()) {
            throw new EmptyCartException();
        }
        double subtotal = cart.calculateSubtotal();
        double shippingFee = shippableItems.isEmpty() ? 0.0 : shippingService.calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > customer.getBalance()) {
            throw new NotEnoughMoneyException(totalAmount, customer.getBalance());
        }
        customer.WithdrawMoney(totalAmount);

        if (!shippableItems.isEmpty()) {
            shippingService.ship(shippableItems);
        }
        
        for (CartItem item : items) {
            item.product.reduceQuantity(item.quantity);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f%n", item.quantity, item.product.getName(),
                    item.quantity * item.product.getPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", totalAmount);
        System.out.printf("Balance left %.0f%n", customer.getBalance());
        cart.getItems().clear();
    }

    private List<IShippable> getShippableItems(Cart cart) {
        List<IShippable> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.product.isShipping() && item.product instanceof IShippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add((IShippable) item.product);
                }
            }
        }
        return shippableItems;
    }
}
