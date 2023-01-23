package com.zzqedu.bubble;

import java.util.Arrays;
import java.util.TreeMap;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,9,7};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                // 从大到小，前边的小就交换
                // if (arr[j] < arr[j+1]) {
                //     temp = arr[j];
                //     arr[j] = arr[j+1];
                //     arr[j+1] = temp;
                // }
                // 从小到大排序，把大的冒上去，大的应该在后面
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void sort2(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSort = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                // 从大到小，前边的小就交换
                // if (arr[j] < arr[j+1]) {
                //     temp = arr[j];
                //     arr[j] = arr[j+1];
                //     arr[j+1] = temp;
                // }
                // 从小到大排序，把大的冒上去，大的应该在后面
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 要交换了，说明不是有序的
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

}

