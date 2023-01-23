package com.zzqedu.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Bucket {
    public static void main(String[] args) {

    }

    public static double[] bucketSort(double[] array) {
        // 得到最大值、最小值
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double diff = max-min;
        // 初始化桶
        // 具体桶的数量有很多方式，这里等于数组的元素数量，最后一个桶放最大值
        // 其他桶按照比例确定
        // 区间跨度：= (max-min)/(bucketNum-1)
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 将元素放入桶中
        for (int i = 0; i < array.length; i++) {
            // 后边是区间跨度 除以区间跨度
            int num =(int)( (array[i] - min) / (diff / (bucketNum-1)) );
            bucketList.get(num).add(array[i]);
        }

        // 堆每个桶内部进行排序
        for (int i = 0; i < bucketNum; i++) {
            //JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }
        // 输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (Double element : list) {
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }



}
