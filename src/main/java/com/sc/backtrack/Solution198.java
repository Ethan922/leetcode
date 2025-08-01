package com.sc.backtrack;

import java.util.Arrays;

public class Solution198 {
    // 打家劫舍II
    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        return Math.max(
                rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob1(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }
}
