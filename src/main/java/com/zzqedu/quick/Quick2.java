package com.zzqedu.quick;

import java.util.Arrays;

public class Quick2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归条件结束的条件
        if (startIndex >= endIndex) {
            return;
        }
        // 获取基准元素
        // 根据基准元素分成两部分进行排序操作
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 获取第一个元素，成为基准元素
        int pivot = arr[startIndex];
        // mark 代表基准元素的区域边界，mark包括并之前的都属于小于等于系列
        int mark = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            // 找到小于基准元素的
            if(arr[i] < pivot) {
                // 代表基准元素区域增加，加了1
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        // 最终基准元素和mark指针所在位置交换，让基准元素去中间
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
