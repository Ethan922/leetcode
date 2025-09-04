package com.sc.review;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    int size;
    final Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.v;

    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.v = val;
            moveToHead(node);
            return;
        }
        if (size == capacity) {
            Node removedNode = removeTail();
            cache.remove(removedNode.k);
            size--;
        }
        node = new Node(key, val);
        addToHead(node);
        cache.put(key, node);
        size++;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return node;
    }

    private Node removeTail() {
        return removeNode(tail.prev);
    }

    static class Node {
        int k, v;
        Node prev, next;

        public Node() {
        }

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
