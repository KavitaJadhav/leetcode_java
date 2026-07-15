package practice;

import java.util.*;

public class Practice {
    public static void main(String[] args){
        String string = "Hello";
        string.length();
        string.charAt(0);

        int[] values = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(values));
        System.out.println(values.length);


        for(int value : values){
            System.out.println(value);
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        list.add(0, 0);
        System.out.println(list.get(0));

        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        System.out.println(list2);

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.pop();
        stack.peek();
        stack.isEmpty();

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.poll();

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.offer(1);
        queue2.offer(2);
        queue2.poll();

        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.offer(5);
        minQueue.offer(4);
        System.out.println(minQueue.poll());

        Queue<Integer> maxQueue = new PriorityQueue<>((num1, num2) -> {
            return num2 - num1;
        });

        maxQueue.offer(5);
        maxQueue.offer(10);
        System.out.println(maxQueue.poll());

        Deque deque = new ArrayDeque<>();
        deque.addLast(10);
        deque.addFirst(5);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.removeLast();
        deque.removeFirst();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        System.out.println(set.size());

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.get(1);
        map.putIfAbsent(1, "one");
        map.getOrDefault(1, "one");
        map.keySet();
        map.containsKey(1);

        }
}
