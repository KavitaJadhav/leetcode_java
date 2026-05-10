//https://leetcode.com/problems/open-the-lock/description/
//Approach Summary (2–3 lines)
//Treat each lock combination as a patterns.graph node.
//Use BFS from "0000", generating neighbors by rotating each wheel ±1.
//Skip deadends and visited states to find the minimum turns to reach target.

//✅ Time Complexity
//States = 10^4
//Time   = O(10^4)
//Space  = O(10^4)

//💡 Interview Tip
//Most interviewers prefer a simpler BFS using String instead of a Lock class because:
//less memory
//shorter code
//easier to reason about
//Your solution is correct conceptually, but the string BFS is the industry-standard approach.

//Rule to remember
//| Graph Type | Algorithm                   |
//| ---------- | --------------------------- |
//| Unweighted | ✅ BFS (Queue)               |
//| Weighted   | ✅ Dijkstra (Priority Queue) |

package patterns.graph;

import java.util.*;

public class OpenLockBFS {

    class Lock {
        String value;
        int turns;
        List<Lock> children = new ArrayList<>();

        public Lock(String value, int turns) {
            this.value = value;
            this.turns = turns;
        }

        private List<Lock> childrens() {

            if (!children.isEmpty()) return children;

            for (int index = 0; index < value.length(); index++) {

                int atIndex = value.charAt(index) - '0';

                StringBuilder sb = new StringBuilder(value);

                sb.setCharAt(index, (char) (((atIndex + 1) % 10) + '0'));
                children.add(new Lock(sb.toString(), turns + 1));

                sb = new StringBuilder(value);
                sb.setCharAt(index, (char) (((atIndex - 1 + 10) % 10) + '0'));
                children.add(new Lock(sb.toString(), turns + 1));
            }

            return children;
        }
    }

    public int openLock(String[] deadEnds, String target) {

        Set<String> visitedSet = new HashSet<>(Arrays.asList(deadEnds));
        Queue<Lock> queue = new ArrayDeque<>();

        if (visitedSet.contains("0000")) return -1;

        queue.add(new Lock("0000", 0));

        while (!queue.isEmpty()) {

            Lock lock = queue.poll();

            if (lock.value.equals(target)) return lock.turns;

            if (!visitedSet.contains(lock.value)) {

                visitedSet.add(lock.value);

                for (Lock child : lock.childrens()) {
                    queue.offer(child);
                }
            }
        }

        return -1;
    }
}

class OpenLockBFSString {
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
                        visited.add(next); //Optimization. to avoid repeated entries in the queue
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