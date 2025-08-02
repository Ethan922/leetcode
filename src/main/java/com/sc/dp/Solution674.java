package com.sc.dp;

public class Solution674 {
    // 最长连续递增子序列
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

