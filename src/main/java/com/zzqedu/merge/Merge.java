package com.zzqedu.merge;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,0,7,1,9};
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    // 想想需要什么参数？arr必须有，临时数组tempArr(合并拷贝的时候在原数组上修改 需要保存临时旧数据)
    // star, end
    public static void sort(int[] arr, int[] tempArr, int statIndex, int endIndex) {
        // 什么时候退出？分解成为一个的时候就退出
        if (endIndex == statIndex) {
            System.out.println("start: " + statIndex + "::end" + endIndex);
            return;
        }
        // 用到了递归, 不断分解的过程就是递归
        int midIndex = statIndex + (endIndex - statIndex) / 2;
        // 递归-每次拆成一左一右
        sort(arr, tempArr, statIndex, midIndex);
        sort(arr, tempArr, midIndex + 1, endIndex);
        // 递归到最小的时候，开始合并，回溯
        // merge();
        // 需要啥参数?
        merge(arr, tempArr, statIndex, midIndex, endIndex);
    }

    private static void merge(int[] arr, int[] tempArr, int statIndex, int midIndex, int endIndex) {
        // 需要在原数组上修改，所以需要保存旧数据
        for (int i = statIndex; i <= endIndex; i++) {
            tempArr[i] = arr[i];
        }
        // left 指向左边数组在tempArr的起始索引
        // right 执行右边数组在tempArr的起始索引
        int left = statIndex;
        int right = midIndex+1;
        for (int i = statIndex; i <= endIndex; i++) {
            // 说明做百年的数据已经排完了，因为两边总有可能不一样，有的左边多一个，有的右边
            if (left > midIndex) {
                arr[i] = tempArr[right++];
                // 说明右边排完了
            } else if (right > endIndex) {
                arr[i] = tempArr[left++];
                // 左边小先排
            } else if (tempArr[left] < tempArr[right]) {
                arr[i] = tempArr[left++];
            } else {
                // 右边小先排
                arr[i] = tempArr[right++];
            }
        }
    }
}
