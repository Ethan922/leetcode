package com.sc.stack;

import java.util.Stack;

public class Solution379 {

    // 每日温度
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                ans[index] = index - i;
            }
            stack.push(i);
        }
        return ans;
    }
}

