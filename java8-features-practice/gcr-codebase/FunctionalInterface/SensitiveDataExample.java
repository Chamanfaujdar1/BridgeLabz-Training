public class SensitiveDataExample {

    interface SensitiveData {
    }

    static class BankAccount implements SensitiveData {
        String accountNumber;
        double balance;

        BankAccount(String acc, double bal) {
            this.accountNumber = acc;
            this.balance = bal;
        }
    }

    static class SecurityService {

        static void process(Object obj) {
            if (obj instanceof SensitiveData) {
                System.out.println("Encrypting sensitive data...");
            } else {
                System.out.println("No encryption needed");
            }
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount("123456", 50000);
        SecurityService.process(account);
    }
}
