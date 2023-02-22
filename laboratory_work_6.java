import java.util.Scanner;
import java.util.Random;
public class laborotornay_rab_6 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива - ");
        int rasmer = in.nextInt();
        int[][] mass = new int[rasmer][rasmer];
        int[] mass1 = new int[rasmer];
        System.out.println("Заполнить массив:");
        zapoln(mass);
        System.out.println("Массив:");
        vuvod_two(mass);
        //Заполнение массива значениями главной диагонали
        for (int i = 0; i<rasmer;i++){mass1[i] = mass[i][i];}
        System.out.println("Отсортированный массив:");
        algor(mass1);
        //Замена
        for (int i = 0; i<rasmer;i++){mass[i][i] = mass1[i];}
        vuvod_two(mass);
    }
    //Сортировка
    static void algor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array [j] < min) {
                    min = array [j];
                    minId = j;}}
            int temp = array[i];
            array [i] = min;
            array[minId] = temp;}}
    // Вывод двоичного массива
    static void vuvod_two(int[][] mass){
        for (int i = 0; i<mass.length;i++){
            for (int y = 0; y<mass.length;y++){System.out.print(mass[i][y]+" ");}
            System.out.println();}}
    // Заполнение массива
    static void zapoln(int[][] mass){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i<mass.length;i++){for (int y = 0; y<mass.length;y++){mass[i][y]= in.nextInt();}}}
}
