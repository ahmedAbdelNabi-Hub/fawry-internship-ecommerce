package domain.Exceptions;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException() {
        super("your cart is empty , Please add items before checkout");
    }
}