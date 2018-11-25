package ThreadArrays;
import java.util.Scanner;
import java.util.Random;
public class Task_28a {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        arr = new int[n];
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(2);
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        RunThread mt1 = new RunThread("Thread 1", 0, arr.length );
        RunThread mt2 = new RunThread("Thread 2", 0, arr.length);

        try {
            mt1.getThread().join();
            mt2.getThread().join();
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted.");
        }
        //System.out.printf("РЎСѓРјРјР° : %d\n", mt1.getSum() + mt2.getSum());
    }

    synchronized public static int sumArray(){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += Task_28a.arr[i];
        }
        return sum;
    }
}