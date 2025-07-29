package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    // 分割回文串
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return ans;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;
            }
            path.add(s.substring(startIndex, i + 1));
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
