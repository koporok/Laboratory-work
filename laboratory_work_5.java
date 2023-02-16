import java.util.Scanner;
public class laboratory_work_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] mass = new int[in.nextInt()];
        for (int i = 0; i < mass.length; i++) {mass[i] = in.nextInt();}
        vuvod(mass);
        algor(mass);
        System.out.println();
        vuvod(mass);
    }

    static void vuvod(int[] mass) {for (int i = 0; i < mass.length; i++) {System.out.print(mass[i] + " ");}}

    static void algor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }
}
