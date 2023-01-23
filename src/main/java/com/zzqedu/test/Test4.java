package com.zzqedu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test4 {
    public static void main(String[] args) {
        // ArrayList<Integer> integers = rangeOfNumbers(6, 9);
        // Integer[] integers1 = integers.toArray(new Integer[3]);
        // System.out.println(Arrays.toString(integers1));
        System.out.println("0".compareTo("1"));
    }

    public static ArrayList<Integer> rangeOfNumbers(int startNum, int endNum) {
        if (endNum == startNum-1) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = rangeOfNumbers(startNum, endNum - 1);
        arrayList.add(endNum);
        return arrayList;
    }

}



