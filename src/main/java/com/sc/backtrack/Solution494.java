package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution494 {
    // 目标和
    List<Integer> path = new ArrayList<>();
    int count = 0;
    int[] sign = new int[]{-1, 1};

    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, 0, 0, target, nums.length);
        return count;
    }

    private void backtracking(int[] nums, int index, int sum, int targetSum, int n) {
        if (index == n) {
            if (sum == targetSum) {
                count++;
            }
            return;
        }
        for (int i = 0; i < sign.length; i++) {
            path.add(sign[i]);
            sum += nums[index] * sign[i];
            backtracking(nums, index + 1, sum, targetSum, n);
            path.remove(path.size() - 1);
            sum -= nums[index] * sign[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{42, 36, 4, 15, 17, 15, 31, 1, 11, 2, 12, 28, 22, 9, 2, 31, 48, 18, 48, 5}, 15));
    }
}
