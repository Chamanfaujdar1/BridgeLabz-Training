public class BankTest {
    public static void main(String[] args){
        SavingsAccount s=new SavingsAccount("SB101",5000);

        Thread t1=new Transaction(s,true);
        Thread t2=new Transaction(s,false);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception e){}

        s.checkBalance();
        System.out.println("Interest: "+s.calculateInterest());
    }
}