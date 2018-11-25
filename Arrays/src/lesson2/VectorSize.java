package lesson2;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class VectorSize {


    public static void main(String[] args) throws java.lang.Exception {
        //System.out.println("Enter n=");
        //Scanner sc = new Scanner(System.in);
        //int n;
        // n = sc.nextInt();
        // int[] a = new int[n];
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            if (isPrime(arr[i])) {
                arr[i] = 0;
                // a[i] = r.nextInt(100);
            }
            System.out.print(" " + arr[i]);
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}

