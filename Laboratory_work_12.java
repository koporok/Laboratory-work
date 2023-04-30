import java.util.Scanner;
public class Laboratory_work_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String IP = in.nextLine();
        boolean result = IP.matches("(\\d\\.|\\d\\d\\.|(1)\\d\\d\\.|2[0-4]\\d\\.|25[0-5]\\.){3}(\\d|\\d\\d|(1)\\d\\d|2[0-4]\\d|25[0-5])");
        if (result){System.out.println("ок");}
        else {System.out.println("error");}
        }

}
