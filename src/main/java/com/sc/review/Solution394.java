package com.sc.review;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        Stack<Integer> multiStack = new Stack<>();
        int multi = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(res.toString());
                multiStack.push(multi);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(stack.pop());
                Integer n = multiStack.pop();
                for (int i = 0; i < n; i++) {
                    temp.append(res);
                }
                res = temp;
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
