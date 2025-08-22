package com.sc.heap;

import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (minHeap.size() == maxHeap.size()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return (double) maxHeap.peek();
            }
        }
    }
}
