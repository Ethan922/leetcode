package com.sc;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    int capacity;

    int size;

    int minFreq;

    static class Node {
        int key;
        int val;
        int freq;

        public Node() {
        }

        public Node(int key, int val) {
            this.freq = 1;
            this.val = val;
            this.key = key;
        }
    }

    private final Map<Integer, Node> cache;

    private final Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                LinkedHashSet<Node> linkedHashSet = freqMap.get(minFreq);
                Node removeNode = linkedHashSet.iterator().next();
                linkedHashSet.remove(removeNode);
                cache.remove(removeNode.key);
                size--;
                if (linkedHashSet.isEmpty()) {
                    freqMap.remove(minFreq);
                }
            }
            size++;
            minFreq = 1;
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            freqMap.computeIfAbsent(minFreq, k -> new LinkedHashSet<>()).add(newNode);
        } else {
            node.val = value;
            cache.put(key, node);
            updateFreq(node);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        LinkedHashSet<Node> linkedHashSet = freqMap.get(oldFreq);
        linkedHashSet.remove(node);
        if (linkedHashSet.isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }
        node.freq++;
        int newFreq = node.freq;
        freqMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(node);
    }

}
