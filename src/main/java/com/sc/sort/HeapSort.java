package com.sc.sort;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        // 建堆
        heapify(nums);
        int len = nums.length;
        // 不断将数组最大值放到最后
        while (len > 1) {
            swap(nums, 0, len - 1);
            len--;
            down(nums, len, 0);
        }

    }

    public void heapify(int[] nums) {
        // 从第一个非叶子节点开始
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            down(nums, nums.length, i);
        }
    }


    private void down(int[] nums, int len, int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < len && nums[left] > nums[max]) {
            max = left;
        }
        if (right < len && nums[right] > nums[max]) {
            max = right;
        }
        if (max != parent) {
            swap(nums, max, parent);
            down(nums, len, max);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {5, 6, 3, 1, 7, 2};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
