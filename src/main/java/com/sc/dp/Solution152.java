package com.sc.dp;

public class Solution152 {
    //
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = nums[0];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]), nums[i]);
            dp[i][1] = Math.min(Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]), nums[i]);
            max = Math.max(dp[i][0], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{2, -3, -2, 4}));
    }
}
