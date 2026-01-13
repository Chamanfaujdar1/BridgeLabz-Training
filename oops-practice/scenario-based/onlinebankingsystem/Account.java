public class Account implements BankService {
    String accNo;
    double bal;

    public Account(String accNo,double bal){
        this.accNo=accNo;
        this.bal=bal;
    }

    public synchronized void deposit(double amt){
        bal+=amt;
        System.out.println("Deposited: "+amt);
    }

    public synchronized void withdraw(double amt) throws InsufficientBalanceException{
        if(amt>bal)
            throw new InsufficientBalanceException("Insufficient Balance");
        bal-=amt;
        System.out.println("Withdrawn: "+amt);
    }

    void checkBalance(){
        System.out.println("Balance: "+bal);
    }
}