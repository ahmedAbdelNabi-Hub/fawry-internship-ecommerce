package Presentation;

import java.time.LocalDate;

import Infrastructure.ShippingService;
import Service.CheckoutService;
import domain.Entities.Cart;
import domain.Entities.Customer;
import domain.Entities.ExpirableShippableProduct;
import domain.Entities.ShippableProduct;
import domain.Entities.SimpleProduct;

public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Ahmed abdel naby", 1000);

        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.now().plusDays(2), 0.2); 
        ExpirableShippableProduct biscuits = new ExpirableShippableProduct("Biscuits", 150, 2, LocalDate.now().plusDays(1), 0.4);
        ShippableProduct tv = new ShippableProduct("TV", 300, 3, 5); 
        SimpleProduct scratchCard = new SimpleProduct("Scratch Card", 50, 10); //  ده متشحنش علشان ملهوش وزن
        ExpirableShippableProduct milk = new ExpirableShippableProduct("Milk", 60, 3,  LocalDate.now().plusDays(1), 1);
        SimpleProduct pen = new SimpleProduct("Pen", 10, 2); //  ده متشحنش علشان ملهوش وزن

        Cart cart = customer.getCart();
        cart.addItem(cheese, 2); 
        cart.addItem(biscuits, 1); 
        cart.addItem(scratchCard, 1); 
        cart.addItem(tv, 1);
        cart.addItem(milk, 1);
        cart.addItem(pen, 2);
        CheckoutService checkoutService = new CheckoutService(new ShippingService());
        checkoutService.checkout(customer, cart);
    }
}
