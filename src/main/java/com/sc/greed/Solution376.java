package com.sc.greed;

public class Solution376 {
    // 摆动序列
    public int wiggleMaxLength(int[] nums) {
        int currDiff = 0;
        int preDiff = 0;
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i] - nums[i + 1];
            if (preDiff >= 0 && currDiff < 0
                    || preDiff <= 0 && currDiff > 0) {
                preDiff=currDiff;
                ans ++;
            }
        }
        return ans;
    }

}
