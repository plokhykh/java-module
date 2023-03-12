package multithreading.practice.sychronization;

public class UnsyncBankTest {

    private static final int COUNTS = 100;
    private static final double INIT_BALANCE = 1000;

    public static void main(String[] args) {

        Bank bank = new Bank(COUNTS, INIT_BALANCE);

        for (int i = 0; i < COUNTS; i++) {
            int fromAcc = i;
            Runnable runnable = () -> {
                try {
                    while (true) {
                        int toAcc = (int) (bank.size() * Math.random());
                        double amount = INIT_BALANCE * Math.random();
                        bank.transfer(fromAcc, toAcc, amount);
                        Thread.sleep((int) (10 * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Runnable run1 = () -> {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("-> Total Balance: %10.2f%n", bank.getTotalBalance());
                }
            };

            new Thread(runnable).start();

            new Thread(run1).start();


        }

    }
}
