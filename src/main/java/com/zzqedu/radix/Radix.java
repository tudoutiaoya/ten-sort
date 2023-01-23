package com.zzqedu.radix;

import java.util.ArrayList;
import java.util.Arrays;

public class Radix {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,9,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        // 最大值, 用于判断什么时候结束
        int max = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 当前排序位置
        int location = 1;

        // 桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        // 长度为10，装入余数0-9的数据
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        while (true) {
            // 判断是否排完
            int dd = (int) Math.pow(10, location-1);
            if (max < dd) {
                break;
            }

            // 数据入桶
            for (int i = 0; i < length; i++) {
                // 计算余数放入相应的桶
                int number = ((arr[i] / dd) % 10);
                bucketList.get(number).add(arr[i]);
            }

            // 写回数组
            int index = 0;
            for (int i = 0; i < 10; i++) {
                int size = bucketList.get(i).size();
                for (int j = 0; j < size; j++) {
                    arr[index++] = bucketList.get(i).get(j);
                }
                // 记得清空
                bucketList.get(i).clear();
            }
            location++;
        }
    }

}
