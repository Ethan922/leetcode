package com.sc.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution503 {

    // 下一个更大的元素II
    public int[] nextGreaterElement(int[] nums) {
        int m = nums.length;
        int[] ans = new int[m * 2];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * m; i++) {
            while (!stack.isEmpty() && nums[i % m] > nums[stack.peek()]) {
                Integer index = stack.pop();
                ans[index] = nums[i % m];
            }
            stack.push(i % m);
        }
        return Arrays.copyOfRange(ans, 0, m);
    }

}

