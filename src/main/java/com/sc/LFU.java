package com.sc;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFU {

    private int size;

    private final int capacity;

    private int minFreq;

    private Map<Integer, Node> cache;

    private Map<Integer, LinkedHashSet<Node>> freqMap;

    static class Node {
        int key;
        int val;
        int freq;

        public Node() {
            this.freq = 1;
        }

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.freq = 1;
        }
    }

    public LFU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {

        return -1;
    }


    public void put(int k, int v) {

    }

    private void updateFreq(int k) {

    }


}
