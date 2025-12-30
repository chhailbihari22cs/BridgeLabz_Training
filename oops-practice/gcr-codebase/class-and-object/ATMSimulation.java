class ATMSimulation {
    private double balance;

    ATMSimulation(double balance) {
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Withdraw amount is : " + amt);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        ATMSimulation acc = new ATMSimulation(700);
        acc.display();
        acc.deposit(200);
        acc.display();
        acc.withdraw(100);
        acc.display();
        acc.withdraw(1000);
    }
}
