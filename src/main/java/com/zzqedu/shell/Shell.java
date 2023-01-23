package com.zzqedu.shell;

import java.util.Arrays;
import java.util.TreeMap;

public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int gap = n/2;
        while (gap > 0) {
            // 将后面的元素进行插入排序，i=gap是因为第一个元素不用排序
            // gap前面的是已经排好的，因为每个插入排序组都有一个元素
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                // 已排序数组的最后一个元素索引
                int j = i - gap;
                // 循环用来找到插入的位置, 比他大(小)的往后移动
                // 从小到大排序: >  从大到小: <
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                // 找到了插入的位置
                // j 是符合 <= temp，要插入的位置是j+gap
                arr[j+gap] = temp;
            }
            // 缩小增量
            gap /= 2;
        }
    }

}
