package patterns.linked_list.doubly;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public LRUCache() {
    }

    class Node {
        int value;
        int key;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }
    }


    // List<Node> list ;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    int capacity;
    int available_capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.available_capacity = capacity;
        // list = new LinkedList<>();
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            addToFront(node);
            available_capacity--;
            evictIfFull();
        }
    }

    private void moveToFront(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.previous = head;
        node.next = head.next;
        head.next.previous= node;
        head.next = node;
    }

    private void addToFront(Node node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous= node;
        head.next = node;
    }

    private void evictIfFull() {
        if (available_capacity >= 0)
            return;
        removeFromBack();
    }

    private void removeFromBack() {
        Node node = tail.previous;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        available_capacity++;
        map.remove(node.key);
    }

    private  void print(){
        Node node = head;
        while(node!=null){
            System.out.println(node.key + " : " + node.value);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2,1);
        lruCache.set(2,2);
        System.out.println(lruCache.get(2));
        lruCache.set(1,1);
        lruCache.set(4,1);
        System.out.println(lruCache.get(2));
        lruCache.print();

//        LRUCache lruCache = new LRUCache(1);
//        lruCache.set(2,1);
//        lruCache.set(2,2);
//        System.out.println(lruCache.get(2));
//        lruCache.set(1,1);
//        lruCache.set(4,1);
//        System.out.println(lruCache.get(2));
    }
}
