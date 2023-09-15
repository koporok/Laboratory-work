public class ChickenAndEgg {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Добавляем задержку, чтобы курица сказала последнее слово
                System.out.println("Курица");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread eggThread = new Thread(() -> {
            try {
                chickenThread.join(); // Ожидаем завершение работы потока с курицей
                System.out.println("Яйцо");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        chickenThread.start();
        eggThread.start();
    }
}
