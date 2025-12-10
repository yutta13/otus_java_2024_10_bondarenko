import java.util.Map;

public interface SimpleATMI {
    void deposit(Banknote banknote, int count);

    Map<Banknote, Integer> cashWithdrawal(int amount) throws SimpleATMException;

    int getBalance();
}
