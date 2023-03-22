class Animal{
    public String food; // еда
    public String location; // место положение
    public String name; // имя
    public String who; // что за животное
    void makeNoise(){} // поднимать шум
    void eat(){} // кушать
    void sleep() {System.out.println("Животное спит");} // сон
}
class Cat extends Animal{
    String breed; // цвет
    String character; // характер
    Cat(String name, String breed, String character) {
        this.name = name;
        this.breed = breed;
        this.character = character;
        who = "Кот";
        food = "птицу";
        location = "на дереве";
    }
    void makeNoise() {System.out.println("Кот по имени " + name + " мяукнул " + location);}
    void eat() {System.out.println("Кот по имени " + name + " поел " + food);}
}
class Dog extends Animal{
    String breed; // порода
    String size; // размер
    Dog(String name, String breed, String size) {
        this.name = name;
        this.breed = breed;
        this.size = size;
        who = "Собака";
        food = "мясо";
        location = "во дворе";
    }
    void makeNoise() {System.out.println("Собака по кличке " + name + " пугает детей " + location);}
    void eat() {System.out.println("Собака по кличке " + name + " поела " + food);}
}
class Horse extends Animal {

    String color; // цвет
    int speed; // скорость

    Horse(String name, String color, int speed) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        who = "Лошадь";
        food = "травы";
        location = "на лугу";
    }
    void makeNoise() {System.out.println("Лошадь по имени " + name + " ржала " + location);}
    void eat() {System.out.println("Лошадь по имени " + name + " поела " + food);}
}
class Veterinar{
    static void treatAnimal(Animal animal) {
        System.out.println(animal.who + " по имени " + animal.name + " ест " + animal.food + " и проживает " + animal.location);
    }
}

public class Laboratory_work_9 {
    public static void main(String[] args){
        Animal Murzik = new Cat("Тоша", "Британский вислоухий", "Ласковый");
        Dog Scharik = new Dog("Крош", "Дворняга", "Огромный");
        Horse Angel = new Horse("Ангел", "Гнедой", 30);
        Murzik.makeNoise();
        Murzik.eat();
        Murzik.sleep();
        Scharik.makeNoise();
        Scharik.eat();
        Scharik.sleep();
        Angel.makeNoise();
        Angel.eat();
        Angel.sleep();
        Veterinar.treatAnimal(Murzik);
        Veterinar.treatAnimal(Scharik);
        Veterinar.treatAnimal(Angel);
    }
}
