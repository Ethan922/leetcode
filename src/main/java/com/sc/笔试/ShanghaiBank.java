package com.sc.笔试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShanghaiBank {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int a, b, c;
//        a = s.contains("red") ? 1 : 0;
//        b = s.contains("yellow") ? 1 : 0;
//        c = s.contains("blue") ? 1 : 0;
//        System.out.println(a + " " + b + " " + c);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int b = sc.nextInt();
        Character[] characters = new Character[a.length()];
        char[] arr = a.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            characters[i] = arr[i];
        }
        Arrays.sort(characters, Comparator.reverseOrder());
        char[] chars = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            chars[i] = characters[i];
        }
        String s = new String(chars);
        if (b == 1) {
            System.out.println(s);
        } else if (b == 2) {
            int ans = 0;
            for (int i = 1; i < s.length(); i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
                if (s1.length() != 1 && s1.charAt(0) == '0') continue;
                if (s2.length() != 1 && s2.charAt(0) == '0') continue;
                int sum = Integer.parseInt(s1) + Integer.parseInt(s2);
                ans = Math.max(ans, sum);
            }
            System.out.println(ans);
        }
    }

}
