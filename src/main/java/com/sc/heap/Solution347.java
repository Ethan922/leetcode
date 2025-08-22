package com.sc.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    // 前k个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            Integer num = entry.getKey();
            if (queue.size() == k) {
                if (count > queue.peek()[0]) {
                    queue.poll();
                    queue.offer(new int[]{count, num});
                }
            } else {
                queue.offer(new int[]{count, num});
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (int[] arr : queue) {
            ans[i++] = arr[1];
        }
        return ans;
    }
}
