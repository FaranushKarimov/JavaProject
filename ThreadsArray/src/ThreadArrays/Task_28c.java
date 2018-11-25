package ThreadArrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_28c {
    public static int[] arr;

    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        arr = new int[n];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }

        MyThread mt1 = new MyThread("Thread 1", 0, arr.length - arr.length / 2);
        MyThread mt2 = new MyThread("Thread 2", arr.length - arr.length / 2, arr.length);

        try {
            mt1.getThread().join();
            mt2.getThread().join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted.");
        }
        System.out.printf("РЎСѓРјРјР° : %d\n", mt1.getSum() + mt2.getSum());*/

        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Please enter size of array: ");
        n = sc.nextInt();
        arr = new int[n];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(2);
            System.out.print(arr[i] + ", ");
        }
        System.out.println();


        System.out.println("Please enter count of thread: ");
        int k = 0;
        k = sc.nextInt();
        while (k > n) {
            System.out.println("Threads bigger than size: ");
            k = sc.nextInt();
        }
        MyThread[] mts = new MyThread[k];
        int indexStart = 0;
        int indexFinish = 0;
        for (int i = 0; i < k; i++) {
            if (k - i > n % k) {
                indexFinish = indexStart + (n / k);
                mts[i] = new MyThread("Thread" + i, indexStart, indexFinish);
                indexStart = indexFinish;
            } else {
                indexFinish = indexStart + (n / k) + 1;
                mts[i] = new MyThread("Thread" + i, i * (n / k), (i + 1) * (n / k) + 1);
                indexStart = indexFinish;
            }
        }
        try {
            for (int i = 0; i < k; i++) {
                mts[i].getThread().join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted.");
        }

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += mts[i].getSum();
        }
        System.out.printf("Summary : " + total);
    }
}
