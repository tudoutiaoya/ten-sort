package com.zzqedu.quick;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件 ,这里必须是>=，和归并排序不一样，因为是以基准元素为划分，
        // 以最后剩下4个元素为例，最后会分成一个基准，左边2个，右边1个，2个中会选出一个基准，会出现s>e
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素的位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 根据基准元素，分成左右两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第1个位置（也可以为随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            // 从小到大排序
            // right是找小的过程
            // 这里也要控制left<right，因为循环条件满足了，进来了，但是有可能找不到[小]，指针一直移动
            // 大的不找，找小于或者等于的，这里体现了不稳定性
            while (left<right && arr[right]>pivot) {
                right--;
            }
            // left是找大的过程
            while (left<right && arr[left]<=pivot) {
                left++;
            }
            // 最终指针会重合,不会出现错开的情况
            // 指针没有重合的时候交换left right
            if (left<right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

}
