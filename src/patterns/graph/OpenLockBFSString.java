package patterns.graph;

import java.util.*;

public class OpenLockBFSString {

    public int openLock(String[] deadEnds, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadEnds));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        if (dead.contains("0000")) return -1;

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (curr.equals(target)) return turns;

                for (String next : getNeighbors(curr)) {

                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            turns++;
        }

        return -1;
    }

    private List<String> getNeighbors(String curr) {

        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            char[] chars = curr.toCharArray();

            // move wheel forward
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            neighbors.add(new String(chars));

            // move wheel backward
            chars = curr.toCharArray();
            chars[i] = (char) ((chars[i] - '0' - 1 + 10) % 10 + '0');
            neighbors.add(new String(chars));
        }

        return neighbors;
    }
}