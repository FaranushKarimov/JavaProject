package ThreadArrays;

public class Main3 {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 2, 1, 1};

        Array leftSum = new Array(array, 0, array.length/2);
        Array rightSum = new Array(array, array.length/2, array.length);

        leftSum.start();
        rightSum.start();
        try{;
            leftSum.join();
            rightSum.join();
        }catch (InterruptedException e){
        }

        System.out.println(leftSum.getSum() + rightSum.getSum());

    }
}
