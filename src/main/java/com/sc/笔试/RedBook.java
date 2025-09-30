package com.sc.笔试;

import java.util.Scanner;

public class RedBook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int sum = 0;
            int n = sc.nextInt();
            if (n==2){
                System.out.println("NO");
                continue;
            }
            if (check(n)) {
                System.out.println("YES");
                continue;
            }
            for (int j = 2; j*j<=n; j++) {
                if (n % j == 0) {
                    if (check(j)) {
                        sum += j;
                    }
                }
            }
            if (sum % 2 == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s = sc.next();
//        while (true) {
//            int len = s.length();
//            boolean flag = true;
//            boolean[] temp = new boolean[len];
//            for (int i = 1; i < len; i++) {
//                if (s.charAt(i) != s.charAt(i - 1)) {
//                    temp[i] = true;
//                    flag = false;
//                }
//            }
//            if (flag) break;
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < temp.length; i++) {
//                if (!temp[i]) {
//                    stringBuilder.append(s.charAt(i));
//                }
//            }
//            s = stringBuilder.toString();
//            System.out.println(s);
//        }
//        System.out.println(n - s.length());
//    }

}
