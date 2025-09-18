package com.sc.笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Trip {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Set<Integer> set = new HashSet<>();
//        set.add(153);
//        set.add(370);
//        set.add(371);
//        set.add(407);
//        int n = sc.nextInt();
//        if (set.contains(n)){
//            System.out.println("YES");
//        }else {
//            System.out.println("NO");
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s = sc.next();
//        char[] chars = s.toCharArray();
//        StringBuilder ans = new StringBuilder();
//        for (int i = n - 1; i >= 0; i--) {
//            if (chars[i] >= 'a' && chars[i] <= 'z') {
//                if (chars[i] == 'a') {
//                    chars[i] = 'z';
//                } else {
//                    chars[i] -= 1;
//                }
//            } else {
//                if (chars[i] == 'Z') {
//                    chars[i] = 'A';
//                } else {
//                    chars[i] += 1;
//                }
//            }
//            if (i == n - 1) {
//                ans.append(chars[i]);
//            } else {
//                char pre = ans.charAt(ans.length() - 1);
//                if (Math.abs(pre - chars[i]) != 32) {
//                    ans.append(chars[i]);
//                }
//            }
//        }
//        System.out.println(ans.reverse());
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int m = 0; m < t; m++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (set.contains(nums[i])) continue;
                set.add(nums[i]);
                long sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += nums[j] ^ nums[i];
                }
                if (sum > ans) {
                    ans = sum;
                    System.out.println("----" + i);
                }
            }
            System.out.println(ans);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int ans = getCount(nums, n, 0, 0);
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isOrder(nums, i, j)) continue;
//                ans = Math.min(ans, getCount(nums, n, i, j));
//            }
//        }
//        System.out.println(ans);
//    }
//
//    public static boolean isOrder(int[] nums, int i, int j) {
//        for (int k = i; k < j; k++) {
//            if (nums[k] > nums[k + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static int getCount(int[] nums, int n, int i, int j) {
//        reverse(nums, i, j);
//        int count = 0;
//        for (int k = 0; k < n - 1; k++) {
//            for (int m = k + 1; m < n; m++) {
//                if (nums[k] > nums[m]) {
//                    count++;
//                }
//            }
//        }
//        reverse(nums, i, j);
//        return count;
//    }
//
//    public static void reverse(int[] nums, int i, int j) {
//        while (i < j) {
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            i++;
//            j--;
//        }
//    }

}
