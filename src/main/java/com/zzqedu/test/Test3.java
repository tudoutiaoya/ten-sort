package com.zzqedu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> countdown = countdown(5);

        Integer[] integers = countdown.toArray(new Integer[5]);
        System.out.println(Arrays.toString(integers));
    }

    public static LinkedList<Integer> countdown(int n) {
        if(n <= 0) {
            return new LinkedList<>();
        }
        LinkedList<Integer> array = countdown(n - 1);
        array.addFirst(n);
        return array;
    }

}
