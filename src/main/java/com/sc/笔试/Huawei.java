package com.sc.笔试;

import java.util.Scanner;

public class Huawei {

    static int ans = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[][] bug = new int[2][2];
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        visited = new boolean[m][n];
        char[][] grid = new char[m][n];
        int[] start = new int[2];
        int[] end = new int[2];
        int k = 0;
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == '2') {
                    bug[k][0] = i;
                    bug[k][1] = j;
                    k++;
                }
            }
        }
        dfs(grid, start[0], start[1], end, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void dfs(char[][] grid, int i, int j, int[] end, int step) {
        if (i == end[0] && j == end[1]) {
            ans = Math.min(step, ans);
            return;
        }
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '1' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid[i][j] == '2' && !flag) {
            int x, y;
            if (bug[0][0] == i && bug[0][1] == j) {
                x = bug[1][0];
                y = bug[1][1];
            } else {
                x = bug[0][0];
                y = bug[0][1];
            }
            flag = true;
            dfs(grid, x, y, end, step);
        } else {
            for (int[] direction : directions) {
                dfs(grid, i + direction[0], j + direction[1], end, step + 1);
            }
        }
        visited[i][j] = false;

    }

}
