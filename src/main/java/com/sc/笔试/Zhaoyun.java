package com.sc.笔试;

import java.util.Arrays;
import java.util.Scanner;

public class Zhaoyun {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            String str = strs[strs.length - 1];
            strs[strs.length - 1] = str.substring(0, str.length() - 1);
            Arrays.sort(strs, (o1, o2) -> {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    StringBuilder sb1 = new StringBuilder(o1);
                    StringBuilder sb2 = new StringBuilder(o2);
                    sb1.reverse();
                    sb2.reverse();
                    return sb1.toString().compareTo(sb2.toString());
                }
            });
            for (int i = 0; i < strs.length; i++) {
                System.out.print(strs[i]);
                if (i != strs.length - 1) {
                    System.out.print(" ");
                }
            }
    }
}
