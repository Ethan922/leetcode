package com.sc.binarysearch;

public class Solution33 {
    // 搜索旋转排序数组
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[r]) {
                if (nums[mid] < target || nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            } else if (target > nums[r]) {
                if (nums[mid] > target || nums[mid] < nums[r]) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else {
                return r;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }
}
