package com.sc;

import java.util.ArrayList;
import java.util.List;

public class Soluiton1 {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    List<List<String>> ans = new ArrayList<>();
    List<int[]> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, n);
        return ans;
    }

    public void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (!check(row, i)) continue;
            board[row][i] = 'Q';
            path.add(new int[]{row, i});
            backtrack(board, row + 1, n);
            path.remove(path.size() - 1);
            board[row][i] = '.';
        }
    }

    public boolean check(int i, int j) {
        for (int[] index : path) {
            int x = Math.abs(index[0] - i);
            int y = Math.abs(index[1] - j);
            if (x == 0 || y == 0 || x == y) {
                return false;
            }
        }
        return true;
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ans.next = list1;
                list1 = list1.next;
            } else {
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }
        if (list1 == null) {
            ans.next = list2;
        }
        if (list2 == null) {
            ans.next = list1;
        }
        return temp.next;
    }


    public void reverseArr(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
