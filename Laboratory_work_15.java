import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Laboratory_work_15 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10);
        calculator.fun();
        System.out.printf("%f %d\n", calculator.getY(), calculator.getX());
        Scanner in = new Scanner(System.in);

        while (true){
            String cmd = in.nextLine();
            switch (cmd) {
                case "save": // Код для сохранения состояния объекта в файл
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            new FileOutputStream("calc.out"))) {
                        objectOutputStream.writeObject(calculator);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "load": // Код для загрузки состояния объекта из файла
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(
                            new FileInputStream("calc.out"))) {
                        Calculator calc = (Calculator) objectInputStream.readObject();
                        System.out.printf("%f %d\n", calc.getY(), calc.getX());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit": // Выход из программы
                    return;
                default:
                    System.out.println("Write another command");
                    break;
            }
        }
    }
}
