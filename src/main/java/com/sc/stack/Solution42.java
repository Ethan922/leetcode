package com.sc.stack;

import java.util.Stack;

public class Solution42 {

    // 接雨水
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int midIndex = stack.pop();
                if (stack.isEmpty()) break;
                int leftMaxIndex = stack.peek();
                int width = i - leftMaxIndex - 1;
                ans += (Math.min(height[leftMaxIndex], height[i]) - height[midIndex]) * width;
            }
            stack.push(i);
        }
        return ans;
    }

}

