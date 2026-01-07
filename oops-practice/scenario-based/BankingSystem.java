// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Abstraction
interface BankingService {
    void transferFunds(Account recipient, double amount) throws InsufficientFundsException;
}

// Base Class (OOP: Inheritance)
abstract class Account {
    String accountNumber;
    double accountBalance;

    Account(String accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    // Synchronized to ensure thread safety
    public synchronized void depositFunds(double amount) {
        accountBalance += amount;
    }

    public synchronized void withdrawFunds(double amount) throws InsufficientFundsException {
        if (amount > accountBalance) {
            throw new InsufficientFundsException("Insufficient balance in account: " + accountNumber);
        }
        accountBalance -= amount;
    }

    abstract void computeInterest();
}

// Polymorphism: Different Interest Calculations
class SavingsAccount extends Account {
    SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    void computeInterest() {
        System.out.println("Interest earned: " + (accountBalance * 0.04));
    }
}

class CurrentAccount extends Account implements BankingService {
    CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    void computeInterest() {
        System.out.println("No interest applicable for Current Account.");
    }

    @Override
    public void transferFunds(Account recipient, double amount) throws InsufficientFundsException {
        this.withdrawFunds(amount);
        recipient.depositFunds(amount);
        System.out.println("Transfer successful! Remaining Balance: " + this.accountBalance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        CurrentAccount myAccount = new CurrentAccount("CA123", 5000);
        SavingsAccount friendAccount = new SavingsAccount("SA456", 1000);

        // Multithreading simulation using a Thread
        Thread transactionThread = new Thread(() -> {
            try {
                myAccount.transferFunds(friendAccount, 2000);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        });

        transactionThread.start();
    }
}