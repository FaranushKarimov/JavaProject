package Lesson1;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n = 1,m;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        for(int i = 1; i <= m;i++) {
            n = n * i;
        }
        System.out.println(n);
    }
}
