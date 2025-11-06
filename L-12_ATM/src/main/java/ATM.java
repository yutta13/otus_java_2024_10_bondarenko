import java.util.EnumMap;
import java.util.Map;

public class ATM implements SimpleATMI {

    private final Map<Banknote, Integer> cells = new EnumMap<>(Banknote.class);

    public ATM() {
        for (Banknote banknote : Banknote.values()) cells.put(banknote, 0);
    }

    @Override
    public void deposit(Banknote banknote, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Illegal count of Banknotes");
        }
        cells.put(banknote, cells.get(banknote) + count);
    }

    @Override
    public Map<Banknote, Integer> cashWithdrawal(int amount) throws SimpleATMException {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount cannot be equal to 0");
        }

        if (amount > getBalance()) {
            throw new SimpleATMException("There are not enough banknotes in the ATM");
        }

        Map<Banknote, Integer> result = new EnumMap<>(Banknote.class);
        int remainingAmount = amount;

        for (Banknote banknote : Banknote.values()) {
            if (remainingAmount == 0) break;

            int available = cells.get(banknote);
            if (available > 0 && banknote.getNominal() <= remainingAmount) {
                int needed = remainingAmount / banknote.getNominal();
                int take = Math.min(needed, available);

                result.put(banknote, take);
                remainingAmount -= take * banknote.getNominal();
            }
        }

        if (remainingAmount != 0) {
            throw new SimpleATMException("Cannot dispense requested amount with available banknotes");
        }

        result.forEach((b, count) -> cells.put(b, cells.get(b) - count));

        return result;
    }

    @Override
    public int getBalance() {
        int balance = 0;
        for (Map.Entry<Banknote, Integer> entry : cells.entrySet()) {
            balance += entry.getKey().getNominal() * entry.getValue();
        }
        return balance;
    }
}
