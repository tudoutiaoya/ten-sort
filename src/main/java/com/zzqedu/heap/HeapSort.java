package com.zzqedu.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,0,7,1,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        // 构建堆
        buildHeap(arr, length);
        for (int i = length-1; i > 0; i--) {
            // 将堆顶元素和末位元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 数组长度-1， 隐藏堆尾元素
            length--;
            // 将堆顶元素下沉，目的是将最大的元素浮到堆顶来
            sink(arr, 0, length);
        }
    }

    /**
     * 构建堆
     * @param arr
     * @param length
     */
    private static void buildHeap(int[] arr, int length) {
        // 从最后一个非叶子节点开始，进行下沉，下的沉下去，将最大的浮上来
        // (length - 1 - 1) /2 = length/2 -1
        for (int i = length/2 -1; i >= 0; i--) {
            sink(arr, i, length);
        }
    }

    /**
     * 下沉操作
     * @param arr
     * @param index
     * @param length
     */
    private static void sink(int[] arr, int index, int length) {
        // 左孩子、右孩子、要调整的节点下边
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int parent = index;

        // 下沉左边
        if (leftChild < length && arr[leftChild] > arr[parent]) {
            parent = leftChild;
        }

        // 下沉右边
        if (rightChild < length && arr[rightChild] > arr[parent]) {
            parent = rightChild;
        }

        // 如果下标不相等，说明调换过了
        if (parent != index) {
            // 交换
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;

            // 继续下沉
            sink(arr, parent, length);
        }
    }

}
