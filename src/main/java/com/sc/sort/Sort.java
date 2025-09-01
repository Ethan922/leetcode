package com.sc.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int[] nums = {3, 41, 5, 56, 6, 7, 4};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int randomIndex = getRandomInt(left, right);
            swap(nums, randomIndex, right);
            int pivotIndex = partition(nums, left, right);
            quickSort(nums, pivotIndex + 1, right);
            quickSort(nums, left, pivotIndex - 1);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        while (left < right) {
            if (nums[left] <= pivot) {
                swap(nums, i, left);
                i++;
            }
            left++;
        }
        swap(nums, i, right);
        return i;
    }

    private static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


    public static void heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(nums, i, size);
        }
        while (size > 1) {
            swap(nums, 0, size - 1);
            size--;
            down(nums, 0, size);
        }
    }

    private static void down(int[] nums, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }
        if (parent != max) {
            swap(nums, max, parent);
            down(nums, max, size);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
