package com.sc.heap;

import java.util.StringJoiner;

public class Heap {

    private int[] arr;
    private int size;
    private int capacity;
    boolean isMax;

    private static final int DEFAULT_CAPACITY = 5;

    public Heap(int initialCapacity, boolean isMax) {
        this.capacity = initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY;
        this.isMax = isMax;
        this.arr = new int[this.capacity];
    }

    public Heap(int initialCapacity) {
        this(initialCapacity, true);
    }

    public Heap() {
        this(DEFAULT_CAPACITY, true);
    }

    public Heap(boolean isMax) {
        this(DEFAULT_CAPACITY, isMax);
    }

    public int size() {
        return this.size;
    }

    // 自动扩容1.5倍
    private void grow() {
        int newCap = this.capacity + (this.capacity >> 1);
        int[] newArr = new int[newCap];
        System.arraycopy(arr, 0, newArr, 0, this.capacity);
        this.arr = newArr;
        this.capacity = newCap;
    }

    // 添加元素到堆中
    public void offer(int val) {
        // 容量已满自动扩容
        if (size == capacity) {
            grow();
        }
        // 将元素添加到数组的最后
        arr[size++] = val;
        // 从该元素上浮
        up(size - 1);
    }

    // 获得堆顶元素
    public int peek() {
        if (size == 0) {
            throw new RuntimeException();
        }
        return arr[0];
    }

    // 移除堆顶元素
    public int poll() {
        if (size == 0) {
            throw new RuntimeException();
        }
        int top = arr[0];
        // 将堆顶与最后一个元素交换
        swap(0, size - 1);
        size--;
        // 从堆顶开始下潜
        down(0);
        return top;
    }

    private void heapify() {
        // 建堆，从最后一个非叶子节点开始调整
        // 最后一个叶子节点的索引：size/2 - 1
        for (int i = size / 2 - 1; i >= 0; i++) {
            down(i);
        }
    }

    // 上浮元素
    private void up(int child) {
        // 计算父节点的下标
        // 父节点的下标：(index - 1) / 2
        int parent = (child - 1) / 2;
        if (isMax ? arr[child] > arr[parent] : arr[child] < arr[parent]) {
            swap(child, parent);
            up(parent);
        }
    }

    // 下潜元素
    private void down(int parent) {
        // 计算左右孩子下标
        // 左孩子下标：index * 2 + 1
        // 右孩子下标：left + 1
        int left = parent * 2 + 1;
        int right = left + 1;
        int minOrMax = arr[parent];
        if (left < size && isMax ? arr[left] > arr[minOrMax] : arr[left] < arr[minOrMax]) {
            minOrMax = left;
        }
        if (right < size && isMax ? arr[right] > arr[minOrMax] : arr[right] < arr[minOrMax]) {
            minOrMax = right;
        }
        if (minOrMax != parent) {
            swap(minOrMax, parent);
            down(minOrMax);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(String.valueOf(arr[i]));
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(3);
        maxHeap.offer(5);
        maxHeap.offer(4);
        maxHeap.offer(7);
        System.out.println(maxHeap);
        Heap minHeap = new Heap(false);
        minHeap.offer(7);
        minHeap.offer(3);
        minHeap.offer(2);
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(6);
        System.out.println(minHeap);
    }

}
