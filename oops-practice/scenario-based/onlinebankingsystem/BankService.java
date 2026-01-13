public interface BankService {
    void deposit(double amt);
    void withdraw(double amt) throws InsufficientBalanceException;
}