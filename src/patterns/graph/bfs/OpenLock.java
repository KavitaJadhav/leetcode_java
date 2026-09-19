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

package patterns.graph.bfs;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadEnds, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadEnds));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        if (dead.contains("0000")) return -1;

        queue.offer("0000");
        visited.add("0000");

        int turns = 0;

        while (!queue.isEmpty()) {

            int count = queue.size();

            for (int counter = 1; counter <= count; counter++) {

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

    private List<String> getNeighbors(String lock) {

        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            char[] chars = lock.toCharArray();

            // move wheel forward
            chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
            neighbors.add(new String(chars));

            // move wheel backward
            chars = lock.toCharArray();
            chars[i] = (char) ((chars[i] - '0' - 1 + 10) % 10 + '0');
            neighbors.add(new String(chars));
        }

        return neighbors;
    }
}