public class popop extends Thread {
    private String name;
    private int priority;

    public popop(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void run() {
        int distance = 0;
        while (distance < 100) {
            try {
                sleep(100); // добавляем небольшую задержку, чтобы увидеть изменение приоритета
                distance += priority; // увеличиваем пройденное расстояние на приоритет потока
                System.out.println(name + " преодолел " + distance + " метров.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " финишировал!");
    }
}
public class RabbitAndTurtle {
    public static void main(String[] args) {
        popop rabbitThread = new popop("Кролик", 2);
        popop turtleThread = new popop("Черепаха", 1);

        rabbitThread.start();
        turtleThread.start();
    }
}
