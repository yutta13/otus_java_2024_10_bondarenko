public class ATMEmulatorMain {
    public static void main(String[] args) {
        SimpleATMI SimpleATMI = new ATM();

        System.out.println("Current Balance Before: " + SimpleATMI.getBalance());

        SimpleATMI.deposit(Banknote.RUB_100, 5);
        SimpleATMI.deposit(Banknote.RUB_500, 5);
        SimpleATMI.deposit(Banknote.RUB_1000, 5);

        System.out.println("Current Balance After Deposit: " + SimpleATMI.getBalance());

        try {
            SimpleATMI.cashWithdrawal(1100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Current Balance after withdrawal: " + SimpleATMI.getBalance());
    }
}
