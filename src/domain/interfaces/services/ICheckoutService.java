package domain.interfaces.services;

import domain.Entities.Cart;
import domain.Entities.Customer;

public interface ICheckoutService {
    void checkout(Customer customer, Cart cart);

}
