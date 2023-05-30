import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuffer in = new StringBuffer();
        try(FileReader reader = new FileReader("src/with_coms.java")){ //открытие файла и его чтение
            int sym = -1;
            while ((sym = reader.read()) != -1){
                in.append(Character.toChars(sym));
            }
        }
        catch (IOException ex){ // Если происходит ошибка ввода-вывода, то выводится стек вызовов исключения
            ex.printStackTrace();
        }
        finally {
            System.out.println(in.toString());
        }
        Pattern pattern = Pattern.compile("(/{2}[^\n]*\n)|(/\\*.*?\\*/)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(in.toString()); //Создается Matcher, который будет использовать паттерн для поиска совпадений в in
        if(matcher.find()){
            System.out.println(matcher.replaceAll(""));//Выводится содержимое in, из которого удалены найденные комментарии с помощью replaceAll("")
        }
    }
}