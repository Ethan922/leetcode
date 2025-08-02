package com.sc.backtrack;

public class Solution115 {
    // 不同的子序列
    int ans = 0;

    public int numDistinct(String s, String t) {
        backtracking(s.toCharArray(), "", t, 0, 0);
        return ans;
    }

    public void backtracking(char[] chars, String str, String t, int startIndex, int index) {
        if (startIndex == t.length()) {
            if (str.equals(t)) ans++;
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] != t.charAt(startIndex)) continue;
            backtracking(chars, str + chars[i], t, startIndex + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Solution115 solution115 = new Solution115();
        System.out.println(solution115.numDistinct("rabbbit", "rabbit"));
    }
}
