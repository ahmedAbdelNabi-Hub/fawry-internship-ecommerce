package domain.Exceptions;

public class ExpiredProductException extends RuntimeException {
    public ExpiredProductException(String productName) {
        super(String.format(
                "sorry %s has expired and not be added",
                productName));
    }
}