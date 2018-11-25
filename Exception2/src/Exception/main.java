package Exception;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        try{
            System.out.println("Введите число: ");
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int result;
            result=Number.getNumber(m);
        }
        catch (IntervalException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }
    }
}
