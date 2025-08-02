package com.sc.dp;

public class Solution53 {
    // 最大子数组和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}

