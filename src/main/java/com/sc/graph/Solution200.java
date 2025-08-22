package com.sc.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 岛屿数量
    public int numIslands(char[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    // 广度优先遍历
    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextI = index[0] + directions[k][0];
                int nextJ = index[1] + directions[k][1];
                if (nextI < 0 || nextJ < 0 || nextI == grid.length || nextJ == grid[0].length || grid[nextI][nextJ] == '0') {
                    continue;
                }
                grid[nextI][nextJ] = '0';
                queue.offer(new int[]{nextI, nextJ});
            }
        }
    }

    // 深度优先遍历
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + directions[i][0], j + directions[i][1]);
        }
    }
}
