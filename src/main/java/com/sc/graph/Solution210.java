package com.sc.graph;

import java.util.*;

public class Solution210 {
    // 课程表II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegree[to]++;
            map.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                // 入度为0的节点入队
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            ans[i++] = node;
            List<Integer> list = map.getOrDefault(node, new ArrayList<>());
            for (Integer index : list) {
                indegree[index]--;
                if (indegree[index] == 0) {
                    queue.offer(index);
                }
            }
        }
        if (i == numCourses) {
            return ans;
        } else {
            return new int[numCourses];
        }

    }
}
