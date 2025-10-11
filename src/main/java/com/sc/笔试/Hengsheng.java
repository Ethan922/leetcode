package com.sc.笔试;

import java.util.Arrays;
import java.util.Scanner;

public class Hengsheng {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n, ans, a, b;
//        n = sc.nextInt();
//        ans = sc.nextInt();
//        a = sc.nextInt();
//        b = sc.nextInt();
//        sc.nextLine();
//        int ask = 0;
//        int guess = 0;
//        int last = 0;
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            String[] arr = s.split(" ");
//            String op = arr[0];
//            int num = Integer.parseInt(arr[1]);
//            if ("?".equals(op)) {
//                ask++;
//            } else {
//                guess++;
//                last = num;
//            }
//        }
//        if (ask <= a && guess <= b && last == ans) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//    }

    public static void main(String[] args) {
        int ans = -1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        long[] products = new long[n + 1];
        long product = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            product *= nums[i];
            products[i + 1] = product;
        }
        products[0] = 1;
        System.out.println(Arrays.toString(products));
        for (int i = 1; i < products.length; i++) {
            for (int j = 0; j < i; j++) {
                if (products[j] != 0 && check(products[i] / products[j])) {
                    ans = Math.max(ans, i - j);
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean check(long num) {
        double sqrt = Math.sqrt(num);
        return sqrt == (long) sqrt;
    }
}
