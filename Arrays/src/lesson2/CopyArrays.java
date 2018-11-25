package lesson2;
/*import jdk.nashorn.internal.scripts.JO;

import java.util.Arrays;
//import javax.swing.*;
import java.util.Scanner;
public class CopyArrays {
    public static void main(String[] args) {
        System.out.println("Enter size of N = ");
        Scanner in = new Scanner(System.in);
        int size,k = 0;
       // String text = "Одномерный массив случайных чисел: ";
       // size = Integer.parseInt(JOptionPane.showInputDialog("Enter size of array:"));
        //int [] a = new int[size];
        //int [] b = new int [size];
       // int[] nums = new int []{1,2,3,4};
        size = in.nextInt();
        int[] nums = new int[size];
        int[] nums1 = new int [size];
        for(int s : nums) {
           // nums[s] = (int)(10 * Math.random());
            System.out.print(s + " ");
            System.out.println();
        }
        for(int i = 0; i < size;i++) {
            //nums[i] = (int)(10 * Math.random());
            nums[i] = in.nextInt();
            Arrays.sort(nums);
            //text+= nums[i]+" ";
        }
        System.out.println();
        for(int i = 0;i < size;i++) {
            System.out.print(nums[i] + " ");
        }
        boolean t =  Arrays.equals(nums,nums1);
        System.out.println();
        for(int i = 0;i < k;i++) {
            System.out.print(nums1[i] + " ");
            //text+=nums1[i]+" ";
        }
      // JOptionPane.showMessageDialog(null,text);
    }
}
*/
import java.util.Arrays;
public class CopyArrays {
    public static void main(String[] args) throws Exception {
        int[] values = { 1, 2, 3, 4, 5, 5, 5, 6, 6, 7 };
        removeDuplicates(values);
    }

    public static void removeDuplicates(int[] values) {
        boolean mask[] = new boolean[values.length];
        int removeCount = 0;

        for (int i = 0; i < values.length; i++) {
            if (!mask[i]) {
                int tmp = values[i];

                for (int j = i + 1; j < values.length; j++) {
                    if (tmp == values[j]) {
                        mask[j] = true;
                        removeCount++;
                    }
                }
            }
        }
        int[] result = new int[values.length - removeCount];

        for (int i = 0, j = 0; i < values.length; i++) {
            if (!mask[i]) {
                result[j++] = values[i];
            }
        }
        System.out.println(Arrays.toString(result));

    }
}