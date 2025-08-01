package com.sc.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    // 单词拆分
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Set<String> wordDictSet;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordDictSet = new HashSet<>(wordDict);
        backtracking(s, 0);
        return !ans.isEmpty();
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!wordDictSet.contains(substring)) {
                continue;
            }
            path.add(substring);
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        Solution139 solution139 = new Solution139();
        solution139.wordBreak("applepenapple",list);
        System.out.println(solution139.ans);
    }
}
