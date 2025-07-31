package com.sc.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution118 {
    // 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
