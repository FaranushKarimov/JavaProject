package Lesson1;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Scanner;
public class FactBigInt {
    public static void main(String[] args) {
        int m;
        BigInteger n = BigInteger.ONE;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        for(int i = 1;i <= m;i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        System.out.println(n);
    }
}
