package com.sc;

import java.util.Arrays;

public class Shoppe {


    public static void main(String[] args) {
        System.out.println(new Shoppe().findMaximizedCapital(2, 1, new int[]{1, 2, 3}, new int[]{1, 1, 1}));
    }


    int ans;
    boolean[] used;
    int curr;

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        boolean flag = false;
        int[][] nums = new int[profits.length][2];
        for (int i = 0; i < capital.length; i++) {
            if (w >= capital[i]) {
                flag = true;
            }
            nums[i][0] = capital[i];
            nums[i][1] = profits[i];
        }
        Arrays.sort(nums, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        if (!flag) return w;
        curr = w;
        used = new boolean[capital.length];
        backtrack(nums, k, 0);
        return ans;
    }

    public void backtrack(int[][] nums, int k, int index) {
        if (index == k) {
            ans = Math.max(ans, curr);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curr < nums[i][0]) break;
            if (used[i]) continue;
            used[i] = true;
            curr += nums[i][1];
            backtrack(nums, k, index + 1);
            curr -= nums[i][1];
            used[i] = false;
        }
    }


}
