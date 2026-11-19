import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: нельзя пополнить на сумму " + amount);
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }

        LocalDateTime now = LocalDateTime.now();
        Amount newTransaction = new Amount(amount, now, "DEPOSIT");

        transactions.add(newTransaction);

        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: нельзя снять сумму " + amount);
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }

        if (amount > balance) {
            System.out.println("Ошибка: недостаточно денег. Нужно " + amount + ", на счёте " + balance);
            throw new IllegalArgumentException("Недостаточно средств");
        }

        LocalDateTime now = LocalDateTime.now();
        Amount newTransaction = new Amount(amount, now, "WITHDRAWAL");
        transactions.add(newTransaction);

        balance = balance - amount;
    }

    public void printTransactionHistory() {
        System.out.println("История операций счёта " + accountNumber + ":");

        if (transactions.size() == 0) {
            System.out.println("  Операций пока нет");
        }

        for (int i = 0; i < transactions.size(); i++) {
            Amount t = transactions.get(i);
            System.out.println("  " + t.getTransactionType() + ": " + t.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString() {
        return "Счёт №" + accountNumber + ", владелец: " + accountHolder + ", баланс: " + balance;
    }

    public PersonalAccount add(double amount) {
        deposit(amount);
        return this;
    }

    public PersonalAccount subtract(double amount) {
        withdraw(amount);
        return this;
    }
}