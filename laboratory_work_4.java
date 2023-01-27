import java.util.Scanner;
import java.util.Arrays;
public class laboratory_work_4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива, n = ");
        int n = in.nextInt();
        int[] mass = new int[n];
        System.out.println("Ввод матрицы: ");
        for (int i = 0; i < n;i++){mass[i]= in.nextInt();}
        System.out.println(Arrays.toString(mass));
        int min = mass[0];
        for (int num : mass) {if (num < min) {min = num;}}
        System.out.println("Минимальное значение - "+ min);
        double sum = 0;
        for (int i = 0; i < n; i++){sum+=mass[i];}
        sum = sum/n;
        System.out.println("Среднее арифметическиое значение: "+sum);
        sum += min;
        System.out.println("Ответ - "+ sum);
    }
}
