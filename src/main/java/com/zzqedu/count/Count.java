package com.zzqedu.count;

import com.zzqedu.test.Test;

import java.util.Arrays;

public class Count {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,5,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 找出数组中的最大值 最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 创建一个max+1-min的数组 相当于同时位移min个
        int[] countArr = new int[max + 1- min];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        // 放在count数组中的就是有序的，拷贝回arr
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            // countArr中索引所代表的元素出现的个数
            for (int j = countArr[i]; j > 0; j--) {
                arr[index++] = i + min;
            }
        }
    }

}
