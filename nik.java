
import java.util.Scanner;

public class nik {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество денег: ");
        int money = in.nextInt();
        System.out.println("Введите стоимость: ");
        int price = in.nextInt();
        System.out.println("Введите количество шоколадок за обёртку: ");
        int wrap = in.nextInt();

        int chocolate = 0;
        int i = 0;

        while (money != 0) {
            if(money - price < 0){
                break;
            }
            money = money - price;
            chocolate ++;
            if(chocolate % wrap == 0){
                chocolate++;
            }
        }
        System.out.println("Вы можете купить "+ chocolate + " шоколадок");
    }
}
