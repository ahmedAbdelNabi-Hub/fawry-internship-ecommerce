package domain.Exceptions;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(double total, double balance) {
        super(String.format(
                "you need $%.2f but only have $%.2f. please add more money to your account.",
                total, balance));
    }
}