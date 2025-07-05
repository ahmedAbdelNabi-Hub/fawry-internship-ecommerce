package domain.Entities;

public class Customer {

    public String name;
    private double balance;
    private Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean isEnough(double amount) {
        return balance >= amount;
    }

    public void WithdrawMoney(double amount) {
        this.balance -= amount;
    }

    public Cart getCart() {
        return cart;
    }

    public double getBalance() {
        return balance;
    }
}
