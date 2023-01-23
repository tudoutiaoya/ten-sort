package com.zzqedu.heap;


import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        // 1 3 5 4 8 7 6
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(6);
        minHeap.add(4);
        minHeap.add(8);
        minHeap.add(7);
        System.out.println(minHeap.data);
        minHeap.add(5);
        System.out.println(minHeap.data);
        Integer integer = minHeap.extractMin();
        System.out.println(minHeap.data);
    }
}

class MinHeap <E extends Comparable<E>> {
    public ArrayList<E> data;

    public MinHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MinHeap() {
        data = new ArrayList<>();
    }

    // 返回堆中元素个数
    public int size() {
        return data.size();
    }

    // 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获取父亲节点索引
    private int parent(int index) {
        return (index-1)/2;
    }

    // 左孩子节点索引
    private int leftChild(int index) {
        return index*2 + 1;
    }

    // 右孩子节点索引
    private int rightChild(int index) {
        return index*2 + 2;
    }

    // 交换传入的索引两个位置的元素
    public void swap(int i, int j) {
        if (i < 0 || i >= this.size() || j < 0 || j >= this.size()) {
            throw new IllegalArgumentException("Index isillegal");
        }
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    // 堆中添加元素
    public void add(E e) {
        // 特性1： 新插入的元素首先放在数组最后，保持完全二叉树的特性
        data.add(e);
        sifUp(data.size()-1);
    }

    /**
     * 上浮
     * @param i 索引的位置上浮
     */
    private void sifUp(int i) {
        //特性2：比较插入值和其父结点的大小关系，小于父结点则用父结点替换当前值，index位置上升为父结点
        // 当上浮元素大于父亲，继续上浮。并且不能上浮到0之上
        // 直到i 等于 0 或 比 父亲节点小了。
        // 循环是上浮的过程
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
            swap(i, parent(i));
            // 让i来到新的位置，使得循环可以查看新的位置是否还要小
            i = parent(i);
        }
    }

    // 获取堆顶的元素
    public E findMin() {
        return data.get(0);
    }

    // 最小堆出元素
    public E extractMin() {
        E ret = findMin();
        // 0位置和最后一个元素交换
        this.swap(0, data.size()-1);
        // 删除最后一个元素
        data.remove(data.size()-1);
        // 对0处进行下沉操作
        siftDown(0);
        return ret;
    }

    /**
     * 下沉
     * @param i 下沉的坐标
     */
    private void siftDown(int i) {
        while (leftChild(i) < data.size()) {
            // 找到左右节点的最小值的坐标
            int j = leftChild(i);
            if (j+1 < data.size() &&
                    data.get(j+1).compareTo(data.get(j)) < 0) {
                j = j+1;
            }
            if (data.get(i).compareTo(data.get(j)) <= 0) {
                break;
            }
            this.swap(i, j);
            i = j;
        }
    }

}