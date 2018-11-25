package lesson2;

import java.util.*;
import java.lang.*;
import java.io.*;

class ArraySize {
    public static void main(String[] args) throws java.lang.Exception {
        int arr[] = {1, 0, 0, 1, 1, 0, 0, 0, 1};

        int max_seq = 0;
        int idx = -1;

        for (int i = 0, cur_seq = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                cur_seq++;
            }
            if (i == arr.length - 1 || arr[i] != 0) {
                if (cur_seq >= max_seq) {
                    max_seq = cur_seq;
                    idx = i;
                    cur_seq = 0;
                }

                if (i == arr.length - 1 && arr[i] == 0) {
                    idx++;
                }
            }
        }

        System.out.println("count: " + max_seq + ", idx of first elem: " + (idx - max_seq));
    }
}