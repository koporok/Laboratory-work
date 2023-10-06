import java.util.Random;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение на сумму: " + amount);
        System.out.println("Текущий баланс: " + balance);
        notifyAll(); // Пробуждаем все потоки, ожидающие изменения баланса
    }

    public synchronized void withdraw(double amount) {
        while (balance < amount) {
            try {
                wait(); // Приостанавливаем поток, если баланс недостаточен
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println("Снятие: " + amount);
        System.out.println("Текущий баланс: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account(0);

        // Поток для многократного пополнения баланса
        Thread depositThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                double amount = random.nextDouble() * 100; // Случайное пополнение от 0 до 100
                account.deposit(amount);

                try {
                    Thread.sleep(1000); // Пауза для имитации задержки между пополнениями
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositThread.start(); // Запускаем поток для пополнения баланса

        // Главный поток снимает деньги, как только указанная сумма накоплена
        double requiredAmount = 1000;
        account.withdraw(requiredAmount);

        System.out.println("Остаток на балансе: " + account.getBalance());
    }
}
