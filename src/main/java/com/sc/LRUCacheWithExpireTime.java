package com.sc;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheWithExpireTime {

    int capacity;

    int size;

    long ttl = 20L;

    Map<Integer, Node> cache;

    static class Node {
        int key;
        int val;
        long timestamp;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;

    Node tail;

    public LRUCacheWithExpireTime(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        long now = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        long timestamp = node.timestamp;
        if (now > timestamp) {
            // 数据过期
            Node removedNode = removeNode(node);
            cache.remove(removedNode.key);
            return -1;
        }
        refreshTtl(node);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (capacity == size) {
                Node removedNode = removeTail();
                cache.remove(removedNode.key);
                size--;
            }
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            refreshTtl(node);
            size++;
        } else {
            node.val = value;
            moveToHead(node);
            refreshTtl(node);
            cache.put(key, node);
        }
    }

    // 刷新节点的有效期
    public void refreshTtl(Node node) {
        node.timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + ttl;
    }


    // 将节点添加到链表头部
    public void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public Node removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    // 移除双向链表的尾部，即淘汰最久未访问的节点
    public Node removeTail() {
        return removeNode(tail.prev);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}

