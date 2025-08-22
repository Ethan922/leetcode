package com.sc.heap;

public class Solution215 {


    int size;

    public int findKthLargest(int[] nums, int k) {
        size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(nums, i);
        }

        for (int i = 0; i < nums.length - k; i++) {
            swap(nums, 0, size - 1);
            size--;
            down(nums, 0);
        }
        return nums[0];
    }


    private void down(int[] arr, int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && arr[left] < arr[min]) {
            min = left;

        }
        if (right < size && arr[right] < arr[min]) {
            min = right;
        }
        if (min != parent) {
            swap(arr, min, parent);
            down(arr, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        System.out.println(solution215.findKthLargest(new int[]{2, 10, 8, 7, 5, 4, 3, 9, 6, 0, 1}, 9));
    }

}
