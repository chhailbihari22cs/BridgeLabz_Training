public class BankAccountTest {
    public static void main(String[] args) {
        // Test Case 1: Valid Deposit
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        System.out.println("Test Case 1: Balance after deposit: " + account.getBalance()); // Expected: 150.0

        // Test Case 2: Negative Deposit
        try {
            account.deposit(-10.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 2: " + e.getMessage()); // Expected: Deposit amount cannot be negative
        }

        // Test Case 3: Valid Withdrawal
        account.withdraw(50.0);
        System.out.println("Test Case 3: Balance after withdrawal: " + account.getBalance()); // Expected: 100.0

        // Test Case 4: Insufficient Funds
        try {
            account.withdraw(200.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 4: " + e.getMessage()); // Expected: Insufficient funds.
        }
    }
}