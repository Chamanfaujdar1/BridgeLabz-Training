// Base Class: Shared attributes for all bank accounts
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account: " + accountNumber + " | Balance: $" + balance);
    }
}

// Subclass 1: Savings Account
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Type: Savings Account (Interest Rate: " + interestRate + "%)");
    }
}

// Subclass 2: Checking Account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Type: Checking Account (Daily Limit: $" + withdrawalLimit + ")");
    }
}

// Subclass 3: Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    int tenureMonths;

    FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
    }

    void displayAccountType() {
        System.out.println("Type: Fixed Deposit (Tenure: " + tenureMonths + " months)");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA-101", 5000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA-202", 2500.0, 1000.0);
        FixedDepositAccount fd = new FixedDepositAccount("FD-303", 10000.0, 12);

        System.out.println("--- Banking Dashboard ---");
        
        sa.displayDetails();
        sa.displayAccountType();
        System.out.println();

        ca.displayDetails();
        ca.displayAccountType();
        System.out.println();

        fd.displayDetails();
        fd.displayAccountType();
    }
}
