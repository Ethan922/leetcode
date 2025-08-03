package com.sc.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    if (stack.isEmpty()){
                        return false;
                    }
                    Character ch = stack.pop();
                    if (ch != map.get(c)) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()"));
    }

}