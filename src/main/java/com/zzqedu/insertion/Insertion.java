package com.zzqedu.insertion;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 第一次从未排序区域拿出一个放到已排序区域已经是有序的了(就一个)
        for (int i = 1; i < arr.length; i++) {
            // 新元素
            int value = arr[i];
            int j = 0; // 插入的位置
            for (j = i-1; j >=0; j--) {
                // 从后往前，大的直接往后移动一位即可，如果从前往后找到插入位置，需要将后边的元素往后移动
                // 这样在第二层循环中，还得插入一层循环，将待插入后边的元素往后移动，就像数组插入中间一样
                // 从小到大排序
                // 切换排序: > 从小到大  < 从大到小
                if (arr[j] > value) { // 用 > 保证稳定性
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}
