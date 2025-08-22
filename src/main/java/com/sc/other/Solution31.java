package com.sc.other;

public class Solution31 {

    // 下一个排列
    public void nextPermutation(int[] nums) {
        // 从后往前找到一个仅含两个元素的升序序列
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 此时i指向升序序列的第一个元素,i<0则表示nums是逆序的
        if (i >= 0) {
            // 从后往前找到第一个比num[i]大的数，将他们交换
            int j = nums.length - 1;
            while (j > i && nums[j] < nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 此时[i+1,num.length-1]一定是逆序的,翻转[i+1,num.length-1]
        reverse(nums, i + 1, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
