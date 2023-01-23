package com.zzqedu.test;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        foo(1);
    }

    public static void foo(int i) {
        if (i == 4) {
            return;
        }
        System.out.println("foo()begin " + i);
        foo(i+1);
        foo(i+1);
        System.out.println("foo()end " + i);
    }

}
