//https://leetcode.com/problems/lru-cache/

//| Operation | Time     | Why                          |
//| --------- | -------- | ---------------------------- |
//| get       | **O(1)** | hashmap lookup               |
//| put       | **O(1)** | hashmap + doubly linked list |
//| eviction  | **O(1)** | tail removal                 |

        package patterns.hash_map;

import java.util.*;

class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }

    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            moveToFront(node);

            return node.value;
        }

        return -1;
    }


    private void addToFront(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
        this.size++;
        evictIfFull();
    }

    private void moveToFront(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;

        node.next = head.next;
        node.previous = head;

        head.next.previous = node;
        head.next = node;
    }

    private void evictIfFull() {
        if (size > capacity) {
            Node node = tail.previous;
            node.previous.next = tail;
            tail.previous = node.previous;
            node.next = null;
            node.previous = null;

            cacheMap.remove(node.key);
            this.size--;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            Node node = new Node(key, value);
            addToFront(node);
            cacheMap.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */