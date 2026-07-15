package patterns.hash_map;

import java.util.*;

class LFUCache {
    class Node {
        int key, value, freq;
        Node next, previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // New nodes start with frequency 1
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int listSize;

        public DoublyLinkedList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.previous = head;
            this.listSize = 0;
        }

        public void addNode(Node node) {
            node.next = head.next;
            node.previous = head;
            head.next.previous = node;
            head.next = node;
            listSize++;
        }

        public void removeNode(Node node) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            listSize--;
        }

        public Node removeTail() {
            if (listSize > 0) {
                Node node = tail.previous;
                removeNode(node);
                return node;
            }
            return null;
        }
    }

    int capacity;
    int minFrequency;
    Map<Integer, Node> cacheMap = new HashMap<>();
    Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;

        Node node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cacheMap.size() >= capacity) {
                // Evict LRU node from the minFrequency list
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                Node toEvict = minFreqList.removeTail();
                cacheMap.remove(toEvict.key);
            }

            // Add new node
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            minFrequency = 1; // Reset min freq to 1 for new elements

            DoublyLinkedList newList = freqMap.getOrDefault(1, new DoublyLinkedList());
            newList.addNode(newNode);
            freqMap.put(1, newList);
        }
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);

        // If the old list is empty and was the minFrequency, increment minFrequency
        if (oldFreq == minFrequency && oldList.listSize == 0) {
            minFrequency++;
        }

        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }
}