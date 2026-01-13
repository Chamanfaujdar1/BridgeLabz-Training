public class Transaction extends Thread {
    Account acc;
    boolean deposit;

    public Transaction(Account acc,boolean deposit){
        this.acc=acc;
        this.deposit=deposit;
    }

    public void run(){
        try{
            if(deposit)
                acc.deposit(1000);
            else
                acc.withdraw(500);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}