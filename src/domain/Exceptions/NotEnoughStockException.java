package domain.Exceptions;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(String productName) {
        super("quantity not available in the stock for this  " + productName);
    }

    public NotEnoughStockException(String productName, int available, int requested) {
        super(String.format(
                "requested %d items of %s, but only %d available",
                requested, productName, available));
    }
}
