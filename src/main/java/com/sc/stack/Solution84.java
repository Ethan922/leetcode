package com.sc.stack;

import java.util.Arrays;
import java.util.Stack;

public class Solution84 {

    // 柱状图中最大的矩形
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        System.out.println(Arrays.toString(newHeights));
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                Integer index = stack.pop();
                int leftMinIndex = stack.peek();
                int height = newHeights[index];
                int width = i - leftMinIndex - 1;
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        return ans;
    }

}

