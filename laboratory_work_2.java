import java.util.Scanner;
public class laboratory_work_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите n = ");
        int n = in.nextInt();
        System.out.print("Введите x = ");
        int x = in.nextInt();
        if (n < 0 | x <= 0){System.out.println("Не верный ввод значение");}
        else {
            double sum = 2*quichSort(n, x);
            System.out.println("Ответ: " + sum);
        }
    }
    static double quichSort(int n, int x){
        double sum = 0;
        for (int i = 0; i <= n; i++){sum =sum + Math.pow((x-1),(2*i+1))/((2*i+1)*Math.pow((x+1),(2*i+1)));}
        return sum;
    }
}
