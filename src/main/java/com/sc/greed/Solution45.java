package com.sc.greed;

public class Solution45 {
    // 跳跃游戏II
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end=max;
                step++;
            }
        }
        return step;
    }
}
