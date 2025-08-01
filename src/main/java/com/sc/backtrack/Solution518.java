package com.sc.backtrack;

import java.util.Arrays;

public class Solution518 {
    //  零钱兑换II
    int path = 0;
    int count = 0;

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        backTracking(coins, amount, 0);
        return count;
    }

    private void backTracking(int[] coins, int amount, int startIndex) {
        if (path == amount) {
            count++;
            return;
        }
        if (path > amount) {
            return;
        }
        for (int i = startIndex; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            path += coins[i];
            backTracking(coins, amount, i);
            path -= coins[i];
        }
    }

    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        int count = solution518.change(500, new int[]{3,5,7,8,9,10,11});
        System.out.println(count);
    }
}
