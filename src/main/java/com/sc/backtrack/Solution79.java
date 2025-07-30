package com.sc.backtrack;

import java.util.Arrays;

public class Solution79 {
    // 单词搜索

    boolean[][] visited;
    int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (boolean[] arr : visited) {
            Arrays.fill(arr, false);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        boolean found = false;
        visited[i][j] = true;
        for (int[] direction : directions) {
            found = backtracking(board, word, i + direction[0], j + direction[1], index + 1);
            if (found){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
