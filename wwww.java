import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class wwww {
    public static void main(String[] args) {
        int[] maciv = new int[1000];

        int min_37 = 10001;
        int max_73 = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));) {
            int number;
            for (int i = 0; i < 1000; i++) {
                number = Integer.parseInt(reader.readLine());
                maciv[i] = number;

                if ((number % 37 == 0) && (number < min_37)) {min_37 = number;}
                if ((number % 73 == 0) && (number > max_73)) {max_73 = number;}
            }}
        catch(IOException ex){System.out.println(ex.getMessage());}

        int min_sum = 2000;
        int quantity = 0;

        for(int i = 0; i < 1000; i++){
            if (min_37 < maciv[i] || maciv[i] < max_73){
                if(i-1 >= 0 &&!(min_37 < maciv[i-1] || maciv[i-1] < max_73)){
                    quantity++;
                    int sum = maciv[i] + maciv[i-1];
                    if (sum < min_sum){min_sum = sum;}
                }
                if (i + 1 < 1000 &&!(min_37 < maciv[i+1] || maciv[i+1] < max_73)){
                    quantity++;
                    int sum = maciv[i] + maciv[i+1];
                    if (sum < min_sum){min_sum = sum;}
                }
            }
        }
        System.out.println(min_sum);
        System.out.println(quantity);
    }
    }
}
