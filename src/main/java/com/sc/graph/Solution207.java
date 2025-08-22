package com.sc.graph;

import java.util.*;

public class Solution207 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    int count = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];
            // 统计课程数
            // 记录每个节点的入度
            indegree[second]++;
            // 记录边
            map.computeIfAbsent(first, key -> new ArrayList<>()).add(second);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 找到入度为0的节点
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        bfs(indegree, queue);
        return count == numCourses;
    }

    private void bfs(int[] indegree, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            count++;
            // 连接的节点入度减1
            List<Integer> edges = map.getOrDefault(node, new ArrayList<>());
            for (Integer edge : edges) {
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(5, new int[][]{{2, 1}, {2, 0}}));
    }

}
