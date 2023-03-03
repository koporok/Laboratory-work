import java.util.Scanner;
class calculator {
    int x, a, b;

    calculator() {
    }

    calculator(int x){this.x = x;}

    calculator(int a, int b){
        this.a = a;
        this.b = b;
    }
    calculator(int a,int b, int x){
        this.a = a;
        this.b = b;
        this.x = x;
    }
    void example_1(){
        int y = 3*x+5;
        System.out.println("y = "+y);
    }
    void example_2() {
        if(a-b!=0){
            double y = (a+b)/(a-b);
            System.out.println("y = "+y);
        }
        else{System.out.println("Error");}
    }
    void example_3(){
        if (b != 0){
            int y = 1;
            for (int i = 1; i<= (a*x)/b; i++){
                y = y*i;
            }
            System.out.println("y = "+ y);
        }
        else{System.out.println("Error");}
    }
}
    public class Laboratory_work_7 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите уравнение\n1- y=3*x+5 \n2- y=(a+b)/(a-b) \n3- y (a*x)/b");
        int option = in.nextInt();
        if (option == 1){
            System.out.print("Введите x - ");
            int x = in.nextInt();
            calculator example = new calculator(x);
            example.example_1();
        }
        if (option == 2){
            System.out.print("Введите a - ");
            int a = in.nextInt();
            System.out.print("Введите b - ");
            int b = in.nextInt();
            calculator example = new calculator(a,b);
            example.example_2();
        }
        if (option == 3){
            System.out.print("Введите a - ");
            int a = in.nextInt();
            System.out.print("Введите b - ");
            int b = in.nextInt();
            System.out.print("Введите x - ");
            int x = in.nextInt();
            calculator example = new calculator(a,b,x);
            example.example_3();
        }
        else{System.out.println("Error");}
    }
}
