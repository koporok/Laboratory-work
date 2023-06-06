enum Calculato{
    a;
    private int x, y;
    public void setCalculator(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void calculateFunction(){
        double rez = 2*x+3/y;
        System.out.println(rez);
    }

}
public class Laboratory_work_19 {
    public static void main(String[] args) {
        Calculato calculator = Calculato.a;
        calculator.setCalculator(5, 43);
        calculator.calculateFunction();

    }
}
