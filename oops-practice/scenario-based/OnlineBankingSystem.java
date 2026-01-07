import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double checkBalance();
    void transfer(Account toAccount, double amount) throws InsufficientBalanceException;
}

abstract class Account implements BankService {
    int accountNumber;
    String holderName;
    protected double balance;
    List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }

    public synchronized double checkBalance() {
        return balance;
    }

    public void transfer(Account toAccount, double amount) throws InsufficientBalanceException {
        synchronized (this) {
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance for transfer!");
            }
            balance -= amount;
            transactionHistory.add("Transferred " + amount + " to Account " + toAccount.accountNumber);
        }
        synchronized (toAccount) {
            toAccount.balance += amount;
            toAccount.transactionHistory.add("Received " + amount + " from Account " + this.accountNumber);
        }
    }

    abstract double calculateInterest();

    public void showTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber);
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.02;
    }
}

class TransactionTask extends Thread {
    Account from;
    Account to;
    double amount;

    public TransactionTask(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        try {
            from.transfer(to, amount);
            System.out.println(Thread.currentThread().getName()
                    + " transferred " + amount
                    + " from " + from.accountNumber
                    + " to " + to.accountNumber);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class OnlineBankingSystem {

    public static void main(String[] args) {

        Account acc1 = new SavingsAccount(101, "Rahul", 10000);
        Account acc2 = new CurrentAccount(102, "Amit", 5000);

        acc1.deposit(2000);
        try {
            acc2.withdraw(1000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        Thread t1 = new TransactionTask(acc1, acc2, 3000);
        Thread t2 = new TransactionTask(acc1, acc2, 2000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balances:");
        System.out.println("Account 101 Balance: " + acc1.checkBalance());
        System.out.println("Account 102 Balance: " + acc2.checkBalance());

        System.out.println("\nInterest:");
        System.out.println("Savings Account Interest: " + acc1.calculateInterest());
        System.out.println("Current Account Interest: " + acc2.calculateInterest());

        acc1.showTransactionHistory();
        acc2.showTransactionHistory();
    }
}
