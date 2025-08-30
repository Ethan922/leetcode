package com.sc.笔试;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KdxfTest {


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer count : map.values()) {
            if (count > 1) {
                ans += count - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        int flag = 26;
        for (int count : arr) {
            if (count % 2 == 1) {
                ans++;
            }
            if (count == 0) {
                flag--;
            }
        }
        System.out.println(flag == 1 ? 1 : ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int xor1 = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            xor1 ^= nums[i];
            map.put(i, xor1);
        }
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int ans = 0;
            if (op == 1) {
                ans = map.getOrDefault(l-1,0) ^ map.get(r);
            } else {
                Map<Integer, Integer> temp = new HashMap<>();
                for (int j = l; j <= r; j++) {
                    int count = temp.getOrDefault(nums[j], 0) + 1;
                    if (count > 1) {
                        ans ^= nums[j];
                    }
                    temp.put(nums[j], count);
                }
            }

            System.out.println(ans);
        }
    }

}
