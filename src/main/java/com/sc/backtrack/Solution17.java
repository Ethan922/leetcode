package com.sc.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    // 电话号码的字母组合
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        backtracking(digits, 0);
        return ans;
    }

    public void backtracking(String digits, int index) {
        if (path.length() == digits.length()) {
            ans.add(new String(path));
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtracking(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
