package com.sc.笔试;

import com.sc.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Tongcheng {

    public ListNode partition(ListNode pHead, int x) {
        List<Integer> ltList = new ArrayList<>();
        List<Integer> eqList = new ArrayList<>();
        List<Integer> gtList = new ArrayList<>();
        ListNode p = pHead;
        while (p != null) {
            if (p.val < x) {
                ltList.add(p.val);
            } else if (p.val > x) {
                gtList.add(p.val);
            } else {
                eqList.add(p.val);
            }
            p = p.next;
        }
        ListNode ans = new ListNode(0);
        p = ans;
        for (Integer val : ltList) {
            p.next = new ListNode(val);
            p = p.next;
        }
        for (Integer val : eqList) {
            p.next = new ListNode(val);
            p = p.next;
        }
        for (Integer val : gtList) {
            p.next = new ListNode(val);
            p = p.next;
        }
        return ans.next;
    }

    public long maxWater(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return ans;
    }
}
