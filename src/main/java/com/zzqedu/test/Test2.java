package com.zzqedu.test;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,7,6};
        System.out.println(sum(arr, 3));
    }

    public static int sum(int[] arr,int n) {
        if (n <= 0) {
            return 0;
        } else {
            return sum(arr, n-1) + arr[n-1];
        }
    }
}
