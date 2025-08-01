package com.sc.dp;

import java.util.*;

public class Solution139 {
    // 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String word : wordDict) {
                if (i < word.length()) break;
                String substring = s.substring(i - word.length(), i);
                if (wordDictSet.contains(substring) && dp[i - word.length()]) {
                    dp[i] = true;
                }
            }
        }
        for (boolean b : dp) {
            System.out.println(b);
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        Solution139 solution139 = new Solution139();
        solution139.wordBreak("applepenapple", list);
    }
}
