
// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    int withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit per day: " + withdrawalLimit);
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    int tenureInYears;

    FixedDepositAccount(String accountNumber, double balance, int tenureInYears) {
        super(accountNumber, balance);
        this.tenureInYears = tenureInYears;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenureInYears + " years");
    }
}

// Main class
public class BankAccountTypes {
    public static void main(String[] args) {

        BankAccount b1 = new SavingsAccount("SA101", 50000, 4.5);
        BankAccount b2 = new CheckingAccount("CA102", 20000, 5);
        BankAccount b3 = new FixedDepositAccount("FD103", 100000, 3);

        b1.displayAccountType();
        System.out.println();

        b2.displayAccountType();
        System.out.println();

        b3.displayAccountType();
    }
}
