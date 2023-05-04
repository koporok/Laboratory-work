import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Laboratory_work_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String IP = in.nextLine();
        boolean result = IP.matches("(\\d\\.|\\d\\d\\.|(1)\\d\\d\\.|2[0-4]\\d\\.|25[0-5]\\.){3}(\\d|\\d\\d|(1)\\d\\d|2[0-4]\\d|25[0-5])");
        try(FileWriter writer = new FileWriter("out.txt")){
            if (result) {
                System.out.println("ок");
                writer.write(IP);
            } else {
                writer.write("IP is not correct");
                System.out.println("error");
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }


    }
}
