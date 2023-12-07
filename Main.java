import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) {
        try {
            // Создание нового процесса
            Process process;
            if (System.getProperty("os.name").startsWith("Windows")) {
                process = Runtime.getRuntime().exec("cmd /c dir");
            } else {
                process = Runtime.getRuntime().exec("ls");
            }

            // Получение вывода процесса
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Ожидание завершения процесса и получение кода завершения
            int exitCode = process.waitFor();
            System.out.println("\nКод завершения: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
