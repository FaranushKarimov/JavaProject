package Lesson1;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

public class MultOfNumbers {
    public static void main(String[] args) {
        int n;
        BigDecimal m = BigDecimal.ONE;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                m = m.multiply(new BigDecimal((1.0 / (i + j * j))));
            }
        }
        System.out.println(m);

    }
}
