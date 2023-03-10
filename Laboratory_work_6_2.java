 import java.util.Arrays;
import java.util.Scanner;

public class Laboratory_work_6_2{
        public static void main (String[] args) {
                Scanner in = new Scanner (System.in );
                System.out.print("Введите размерность массива - ");
                int rasmer = in.nextInt();
                int[][] mass = new int[rasmer][rasmer];
                int[] mass1 = new int[rasmer];
                System.out.println("Заполнить массив:");
                zapoln (mass);
                System.out.println("Массив:");
                vuvod_two(mass);
                //Заполнение массива значениями главной диагонали
                for (int i = 0; i < rasmer; i++) {
                        mass1[i] = mass [i][i];
                }
                System.out.println("Отсортированный массив:");
                HeapSort(mass1);
                //Замена
                for (int i = 0; i < rasmer; i++) {
                        mass[i][i] = mass1[i];
                }
                vuvod_two(mass);
        }
        public static void HeapSort(int[] array){
                int n = array.length;
                for (int i = n / 2 - 1; i >= 0; i--)
                        heapify(array, n, i);
                for (int i=n-1; i>=0; i--)
                {
                        int temp = array[0];
                        array[0] = array[i];
                        array[i] = temp;
                        heapify(array, i, 0);
                }
        }

        static void heapify (int[] arr, int n, int i)
        {
                int largest = i;
                int l = 2*i + 1;
                int r = 2*i + 2;
                if (l < n && arr[l] > arr[largest])
                        largest = l;
                if (r < n && arr[r] > arr[largest])
                        largest = r;
                if (largest != i)
                {
                        int swap = arr[i];
                        arr[i] = arr[largest];
                        arr[largest] = swap;
                        heapify (arr, n, largest);
                }
        }

        // Вывод двоичного массива
        static void vuvod_two(int[][] mass) {
                for (int i = 0; i < mass.length; i++) {
                        for (int y = 0; y < mass.length; y++) {
                                System.out.print(mass[i][y] + " ");
                        }
                        System.out.println();
                }
        }

        // Заполнение массива
        static void zapoln(int[][] mass) {
                Scanner in = new Scanner(System.in);
                for (int i = 0; i < mass.length; i++) {
                        for (int y = 0; y < mass.length; y++) {
                                mass[i][y] = in.nextInt();
                        }
                }
        }

}