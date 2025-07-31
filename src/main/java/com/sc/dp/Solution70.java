package com.sc.dp;

public class Solution70 {
    // 爬楼梯
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int pre = 1;
        int ans = 2;
        for (int i = 3; i <= n; i++) {
            int temp = ans;
            ans += pre;
            pre = temp;
        }
        return ans;
    }
}
