package com.sc.other;

public class Solution75 {

    // 颜色分类
    public void sortColors(int[] nums) {
        // 三个指针划分数组，[low,mid)代表0区域,[mid,high]代表1区域,(high,n)代表2区域
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
