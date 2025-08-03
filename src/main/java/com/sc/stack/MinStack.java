package com.sc.stack;

import java.util.Stack;

public class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(stack.peek()[1], val)});
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        }
        return 0;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        }
        return Integer.MAX_VALUE;
    }
}