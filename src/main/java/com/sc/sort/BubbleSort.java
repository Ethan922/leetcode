package com.sc.sort;

public class BubbleSort {

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {5, 6, 1, 4, 9, 5, 0};
//        int[] nums = {1, 2, 3, 4, 5};
        bubbleSort.bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
