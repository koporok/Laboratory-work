import java.util.Scanner;

abstract class human{
    String full_name;
    String data;
    String salary;
    abstract void printName();
    abstract void printData();
    abstract void printSalary();
}

class direct extends human{ // директор
    direct(String full_name, String data, String salary){
        this.full_name = full_name; // ФИО
        this.data = data; // год рождения
        this.salary = salary; // размер зарплаты
    }
    void printName() {System.out.println(full_name);}
    void printData() {System.out.println(data);}
    void printSalary() {System.out.println(salary);}
}
class head extends human{ // начальник
    head(String full_name, String data, String salary){
        this.full_name = full_name;
        this.data = data;
        this.salary = salary;
    }
    void printName() {System.out.println(full_name);}
    void printData() {System.out.println(data);}
    void printSalary() {System.out.println(salary);}
}

class worker extends human { // работник
    worker(String full_name, String data, String salary) {
        this.full_name = full_name;
        this.data = data;
        this.salary = salary;
    }
    void printName() {System.out.println(full_name);}
    void printData() {System.out.println(data);}
    void printSalary() {System.out.println(salary);}
}
public class Laboratory_work_10 {
    static String[] input(){
        Scanner in = new Scanner(System.in);
        String[] arr = new String[3];
        arr[0] = in.next();// ввод имнеи
        arr[1] = in.next();// ввод года
        arr[2] = in.next();// ввод зарплаты
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = input();
        human[] workers = new human[3];
        workers[0] = new direct(arr[0], arr[1], arr[2]);
        arr = input();
        workers[1] = new head(arr[0], arr[1], arr[2]);
        arr = input();
        workers[2] = new worker(arr[0], arr[1], arr[2]);
        for (human worker : workers) {
            worker.printData();
            worker.printName();
            worker.printSalary();
        }
    }
}
