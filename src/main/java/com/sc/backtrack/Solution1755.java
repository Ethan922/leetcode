package com.sc.backtrack;

import java.util.Arrays;

public class Solution1755 {

    int ans = Integer.MAX_VALUE;
    int sum = 0;

    public int minAbsDifference(int[] nums, int goal) {
        Arrays.sort(nums);
        backtrack(nums, goal, 0);
        return ans;
    }

    public void backtrack(int[] nums, int goal, int startIndex) {
        ans = Math.min(Math.abs(sum - goal), ans);
        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            backtrack(nums, goal, i + 1);
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        Solution1755 solution1755 = new Solution1755();
        System.out.println(solution1755.minAbsDifference(new int[]{1, 2, 3}, -7));
    }

}
