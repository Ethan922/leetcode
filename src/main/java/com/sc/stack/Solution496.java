package com.sc.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {

    // 下一个更大的元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer index = stack.pop();
                map.put(nums2[index], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

}

