package wallet_transfer;

public class WalletTransfer implements TransferService {
    public void transfer(Wallet f, Wallet t, double amt) throws InsufficientBalanceException {
        if (f.bal < amt)
            throw new InsufficientBalanceException("Low balance");
        f.bal -= amt;
        t.bal += amt;
    }

    public static void main(String[] args) {
        Wallet w1 = new Wallet(500);
        Wallet w2 = new Wallet(200);
        try {
            new WalletTransfer().transfer(w1, w2, 300);
            System.out.println(w1.bal + " " + w2.bal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}