package wallet_transfer;

public interface TransferService {
    void transfer(Wallet from, Wallet to, double amt) throws InsufficientBalanceException;
}