package com.sc.dp;

import java.util.Arrays;

public class Solution494 {
    // 目标和
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) return 0;
        int n = (target + sum) / 2;
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];
    }

}
