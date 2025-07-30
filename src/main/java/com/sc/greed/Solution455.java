package com.sc.greed;

import java.util.Arrays;

public class Solution455 {
    // 分发饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                count++;
                j--;
            }
            i--;
        }
        return count;
    }
}
