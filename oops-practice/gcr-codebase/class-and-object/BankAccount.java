public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayBalance(){
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount){
        System.out.println("Withdraw amount is : " + amount);
        if (amount <= balance) {
            balance -= amount;
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
    }


    public static void main(String[] args){
        BankAccount account = new BankAccount("Aman", 123456, 700.0);
        account.displayBalance();
        account.deposit(200.0);
        account.displayBalance();
        account.withdraw(100.0);
        account.displayBalance();

    }


}
