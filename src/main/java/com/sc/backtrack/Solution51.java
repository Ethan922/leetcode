package com.sc.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    // N皇后
    List<List<String>> ans = new ArrayList<>();
    List<int[]> path = new ArrayList<>();
    char[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        backTracking(n, 0);
        return ans;
    }

    private void backTracking(int n, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chessBoard) {
                list.add(new String(chars));
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check2(row, i, n)) {
                continue;
            }
            path.add(new int[]{row, i});
            chessBoard[row][i] = 'Q';
            backTracking(n, row + 1);
            chessBoard[row][i] = '.';
            path.remove(path.size() - 1);
        }
    }

    private boolean check(int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chessBoard[i][j] == 'Q') {
                    int x = Math.abs(row - i);
                    int y = Math.abs(col - j);
                    if (x == 0 || y == 0 || x == y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean check2(int row, int col, int n) {
        for (int[] arr : path) {
            int x = Math.abs(row - arr[0]);
            int y = Math.abs(col - arr[1]);
            if (x == 0 || y == 0 || x == y) return false;
        }
        return true;
    }
}
