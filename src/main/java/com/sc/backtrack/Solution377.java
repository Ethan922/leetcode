package com.sc.backtrack;

public class Solution377 {
    // 组合总和III
    int count = 0;

    public int combinationSum4(int[] nums, int target) {
        backtracking(nums, target, 0);
        return count;
    }

    public void backtracking(int[] nums, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            sum += nums[i];
            backtracking(nums, target, sum);
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(new com.sc.backtrack.Solution377().combinationSum4(new int[]{2, 1, 3}, 35));
    }
}
