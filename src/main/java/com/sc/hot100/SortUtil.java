package com.sc.hot100;

import java.util.Arrays;

public class SortUtil {

    private static int[] mergeArr(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        int i = 0, j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[index++] = nums1[i];
                i++;
            } else {
                ans[index++] = nums2[j];
                j++;
            }
        }
        if (i < m) {
            while (i < m) {
                ans[index++] = nums1[i++];
            }
        }
        if (j < n) {
            while (j < n) {
                ans[index++] = nums2[j++];
            }
        }
        return ans;
    }

    public static void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(nums, l, r);
            qSort(nums, l, pivotIndex - 1);
            qSort(nums, pivotIndex + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l;
        while (l < r) {
            if (nums[l] < pivot) {
                swap(nums, i, l);
                i++;
            }
            l++;
        }
        swap(nums, i, r);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void heapSort(int[] nums) {
        heapify(nums);
        int size = nums.length;
        while (size > 1) {
            swap(nums, 0, size - 1);
            size--;
            down(nums, 0, size);
        }
    }

    private static void heapify(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 + 1; i >= 0; i--) {
            down(nums, i, size);
        }
    }

    private static void down(int[] nums, int index, int size) {
        int left = index * 2 + 1;
        int right = left + 1;
        int parent = index;
        if (left < size && nums[left] > nums[parent]) {
            parent = left;
        }
        if (right < size && nums[right] > nums[parent]) {
            parent = right;
        }
        if (parent != index) {
            swap(nums, parent, index);
            down(nums, parent, size);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6, 2, 1, 5};
        System.out.println(Arrays.toString(nums));
    }

}
