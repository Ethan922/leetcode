package com.sc.笔试;

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println(m(a)+m(b));
//        int[] nums = new int[2 * n];
//        int index = 0;
//        int i = 0, j = 0;
//        while (i < n && j < n) {
//            if (a[i] <= b[j]) {
//                nums[index++] = a[i];
//                i++;
//            } else {
//                nums[index++] = b[j];
//                j++;
//            }
//        }
//        if (i == n) {
//            while (j < n) {
//                nums[index++] = b[j++];
//            }
//        }
//        if (j == n) {
//            while (i < n) {
//                nums[index++] = a[i++];
//            }
//        }

    }

    public static int m(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void encrypt() {
        int[] directions = {1, -1};
        Scanner sc = new Scanner(System.in);
        String plainText = sc.next();
        int len = plainText.length();
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(plainText);
            return;
        }
        char[][] chars = new char[n][len];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < len; j++) {
                chars[i][j] = ' ';
            }
        }
        int i = 0;
        int index = 0;
        for (int j = 0; j < len; j++) {
            chars[i][j] = plainText.charAt(j);
            int nextI = i + directions[index];
            if (nextI < 0 || nextI == n) {
                index = (index + 1) % 2;
            }
            i = i + directions[index];
        }
        StringBuilder ans = new StringBuilder();
        for (char[] arr : chars) {
            ans.append(new String(arr).replaceAll(" ", ""));
        }
        System.out.println(ans);
    }

    public static void print() {
        for (int i = 100; i <= 999; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                int m = num % 10;
                sum += m * m * m;
                num /= 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
