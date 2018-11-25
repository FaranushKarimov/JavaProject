package ThreadArrays;

public class Array extends Thread {
    private int sum = 0;
    private int startBarrier;
    private int endBarrier;
    private int[] array;

    public Array(int[] array, int startBarrier, int endBarrier) {
        this.array = array;
        this.startBarrier = startBarrier;
        this.endBarrier = endBarrier;
    }

    public void run() {
       for (int i = startBarrier; i < endBarrier; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }

  /*  public static void createThread(int k) {
        for (int i = 0; i < k; i++) {
            Array obj = new Array(i);
            Thread myThread = new Thread(obj);
            myThread.run();
        }
    }*/

}
