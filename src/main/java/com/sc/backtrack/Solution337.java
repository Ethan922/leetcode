package com.sc.backtrack;

import com.sc.TreeNode;

public class Solution337 {
    // 打家劫舍III
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[0] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
    }
}
