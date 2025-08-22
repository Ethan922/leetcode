package com.sc.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {

    // 腐烂的橘子
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 统计新鲜橘子的数量
                    fresh++;
                } else if (grid[i][j] == 2) {
                    // 腐烂的橘子入队
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (fresh > 0 && !queue.isEmpty()) {
            // 腐烂一轮，时间加1
            time++;
            int size = queue.size();
            while (size > 0) {
                int[] index = queue.poll();
                size--;
                // 向四周扩散腐烂
                for (int i = 0; i < 4; i++) {
                    int x = index[0] + directions[i][0];
                    int y = index[1] + directions[i][1];
                    if (x < 0 || y < 0 || x == m || y == n || grid[x][y] != 1) continue;
                    // 当前是新鲜橘子，新鲜橘子数减1
                    fresh--;
                    grid[x][y] = 2;
                    // 腐烂橘子入队
                    queue.offer(new int[]{x, y});
                }
            }
        }
        if (fresh > 0) {
            return -1;
        } else {
            return time;
        }
    }

}
