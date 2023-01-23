package com.zzqedu.selection;

import java.util.Arrays;

public class selection {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 一共拎出来arr.length-1个即可，最后一个就不用了
        for (int i = 0; i < arr.length-1; i++) {
            int min = i; //最小元素下标
            for (int j = i+1; j < arr.length; j++) {
                // 按照从小到大排，每次找到小的拎出来
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 交换位置
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}
