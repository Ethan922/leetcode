package com.sc.heap;

import java.util.Arrays;

public class MaxHeap {

    int[] array;
    int capacity;
    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public MaxHeap(int[] array, int capacity) {
        capacity = Math.max(capacity, array.length);
        this.array = Arrays.copyOf(array, capacity);
        this.capacity = capacity;
        this.size = array.length;
        heapify();
    }


    public void heapify() {
        // 从最后一个非叶子节点开始下潜
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i, this.size);
        }
    }

    // 移除堆顶元素
    public int poll() {
        return poll(0);
    }

    // 移除指定位置元素
    public int poll(int index) {
        if (size > 0) {
            int top = array[index];
            swap(index, size - 1);
            size--;
            down(index, this.size);
            return top;
        }
        throw new RuntimeException();
    }

    // 替换堆顶元素
    public void replace(int replaced) {
        array[0] = replaced;
        down(0, this.size);
    }

    // 获取堆顶元素
    public int peek() {
        if (size > 0) {
            return array[0];
        }
        throw new RuntimeException();
    }

    public void sort() {
        int size = this.size;
        while (size > 1) {
            swap(0, size - 1);
            size--;
            down(0, size);
        }
    }

    // 添加元素
    public boolean offer(int x) {
        if (size < capacity) {
            array[size++] = x;
            up(size - 1);
            return true;
        }
        return false;
    }

    // 将parent索引处的元素下潜，与两个孩子中的较大者比较，直到没有孩子或者本身就是最大
    private void down(int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        // 和左孩子比较
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        // 和右孩子比较
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(max, size);
        }
    }

    // 将index索引处的元素下潜，与父元素比较，如果比父元素大，则交换，直到当前元素到堆顶或比父元素小
    private void up(int index) {
        if (index == 0) return;
        int parent = (index - 1) / 2;
        if (array[index] > array[parent]) {
            swap(index, parent);
            up(parent);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void print() {
        System.out.print("{ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" }");
    }

    public static void main(String[] args) {
        int[] arr = {13, 24, 56, 65, 4};
        MaxHeap heap = new MaxHeap(arr, 10);
        heap.sort();
        heap.print();
    }

}
