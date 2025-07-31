package com.sc.greed;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    // 划分字母区间
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, arr[s.charAt(i) - 'a']);
            if (i == max) {
                ans.add(i - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }
}
