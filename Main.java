import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        // Прочитайте содержимое файла с помощью BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader("24_demo.txt"));

        // Создайте шаблон регулярного выражения для поиска последовательных символов X
        Pattern pattern = Pattern.compile("X{1,}", Pattern.DOTALL);

        int c;
        StringBuilder text = new StringBuilder();

        // Считайте файл посимвольно и добавляйте в StringBuilder
        while ((c = reader.read()) != -1) {
            text.append((char) c);
        }

        //Используйте шаблон для поиска совпадений в тексте
        Matcher matcher = pattern.matcher(text);

        int matchLength;
        int maxMatchLength = 0;

        // Найдите максимальную длину совпадения
        while (matcher.find()){
            matchLength = (matcher.group()).length();
            if(matchLength > maxMatchLength){
                maxMatchLength = matchLength;
            }
        }

        // Выведите максимальную длину совпадения
        System.out.println(maxMatchLength);

        // Закройте программу чтения, чтобы освободить ресурсы
        reader.close();
    }
}