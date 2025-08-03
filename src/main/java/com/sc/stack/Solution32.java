package com.sc.stack;

import java.util.Stack;

public class Solution32 {

    // 最长有效括号
    public int longestValidParentheses(String s) {
        // 栈中保存最后一个没有被匹配的右括号的下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 匹配左括号，弹出栈顶元素
                stack.pop();
                // 如果栈为空，说明没有左括号和他匹配，将他的下标入栈
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 栈不为空，计算有效括号的长度
                    ans = Math.min(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

}
