import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    public static void main(String[] args) {
        List<Integer> processPIDs = getAllProcessPIDs();

// Сортируем список PID
        Collections.sort(processPIDs);

// Выводим отсортированный список PID
        for (int pid : processPIDs) {
            System.out.println("PID: " + pid);
        }
    }

    public static List<Integer> getAllProcessPIDs() {
        List<Integer> processPIDs = new ArrayList<>();

        try {
// Запускаем команду jps для получения списка PID
            Process process = new ProcessBuilder("jps").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
// Разбираем строку и добавляем PID в список
                String[] parts = line.split(" ");
                if (parts.length >= 1) {
                    try {
                        int pid = Integer.parseInt(parts[0]);
                        processPIDs.add(pid);
                    } catch (NumberFormatException e) {
// Пропускаем некорректные строки
                    }
                }
            }

// Дожидаемся завершения процесса jps
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return processPIDs;
    }
}
