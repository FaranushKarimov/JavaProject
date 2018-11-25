package Lesson1;

import java.util.Scanner;

public class MultOfFunction {
    public static void main(String[] args) {
        double size, n = 1;
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                n = n * 1.0 / (i + j * j);
            }
        }
        System.out.println(n);
    }
}
