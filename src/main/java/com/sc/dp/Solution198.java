package com.sc.dp;

public class Solution198 {
    // 打家劫舍
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int pre = nums[0];
        int cur = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
