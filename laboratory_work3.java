public class laboratory_work3 {
    public static void main(String[] args){
        for (int i = 1; i < 11; i++){
            int y;
            System.out.println("Умножение на "+i);
            for (int j = 1; j < 11; j++){
                y = i * j;
                System.out.println(i+"*"+j+"="+y);
            }
        }
    }
}
