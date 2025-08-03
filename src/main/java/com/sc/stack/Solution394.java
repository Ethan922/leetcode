package com.sc.stack;

import java.util.Stack;

public class Solution394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int multi = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[') {
                multiStack.push(multi);
                resStack.push(res.toString());
                res = new StringBuilder();
                multi = 0;
            } else if (c == ']') {
                Integer n = multiStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(resStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return resStack.pop();
    }

}