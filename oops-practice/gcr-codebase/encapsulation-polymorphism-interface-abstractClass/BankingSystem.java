import java.util.*;

abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited Amount: " + amount);
        }
        else{
            System.out.println("Deposit Sufficient Amount");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount < balance){
            System.out.println("Withdrawn Amount: " + amount);
        }
        else{
            System.out.println("Insufficient bank balance.");
        }
    }

    public abstract double calculateInterest();
}

interface Loanable{
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable{
    public SavingsAccount(String accNo, String name, double balance){
        super(accNo, name, balance);
    }
    public double calculateInterest() {
        return getBalance() * 0.08;
    }
    public void applyForLoan(double amount) {
        System.out.println("Savings Account loan applied for " + amount);
    }
    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account loan applied for " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 100000;
    }
}

public class BankingSystem {
    public static void main(String[] args){
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Anuj", 56000));
        accounts.add(new CurrentAccount("CA201", "Arun", 110000));

        for (BankAccount account : accounts) {
            System.out.println("\nAccount Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

            double interest = account.calculateInterest();
            System.out.println("Interest Earned: " + interest);

            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                loanAccount.applyForLoan(50000);
                System.out.println("Loan Eligible: " + loanAccount.calculateLoanEligibility());
            }
        }
    }
}
