package com.sc.笔试;

import java.util.Scanner;

public class Oppo {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if ((n - 1) % 2 == 0) {
                int b = (n - 1) / 2;
                System.out.println((b + 1) + " " + b);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int s = sc.nextInt();
            if (s == 0) {
                System.out.println(0);
            } else {
                long[] dp = new long[s + 1];
                dp[0] = 1;
                for (int j = 1; j <= s; j++) {
                    for (int k = 1; k <= 9; k++) {
                        if (j >= k) {
                            dp[j] += dp[j - k];
                        }
                    }
                }
                long pow = (long) Math.pow(10, 9) + 7;
                System.out.println(dp[s] % pow);
            }
        }
    }

    public static boolean containsZero(int k) {
        String s = String.valueOf(k);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

}
