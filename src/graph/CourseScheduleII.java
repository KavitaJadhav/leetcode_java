//Complexity
//Time: O(V + E) — Each node is visited once, each edge once.
//Space: O(V + E) — For adjacency list + recursion stack + sets.
//https://leetcode.com/problems/course-schedule/description/
package graph;
import java.util.*;

public class CourseScheduleII {

    public int[] canFinish(int numCourses, int[][] prerequisites) {
        // Graph: course -> list of prerequisites
        Map<Integer, List<Integer>> courseDependencyMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseDependencyMap.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            courseDependencyMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited_courses = new HashSet<>();
        Set<Integer> visiting_courses = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!visited_courses.contains(course)) {
                if (!dfs(course, courseDependencyMap, visited_courses, visiting_courses, result)) {
                    return new int[0]; // cycle detected → no valid order
                }
            }
        }

        // Reverse the result to get correct order to take courses
//        Collections.reverse(result);

        int[] ordered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ordered[i] = result.get(i);
        }
        return ordered;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> courseDependencyMap,
                        Set<Integer> visitedCourses, Set<Integer> visitingCourses,
                        List<Integer> result) {
        if (visitedCourses.contains(course)) return true;
        if (visitingCourses.contains(course)) return false; // cycle detected

        visitingCourses.add(course);

        for (int prereq : courseDependencyMap.get(course)) {
            if (!dfs(prereq, courseDependencyMap, visitedCourses, visitingCourses, result)) {
                return false;
            }
        }

        visitingCourses.remove(course);
        visitedCourses.add(course);
        result.add(course); // add course after visiting all prerequisites
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();

        System.out.println(Arrays.toString(cs.canFinish(2, new int[][]{{1, 0}})));              // [0, 1]
        System.out.println(Arrays.toString(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}})));      // []
        System.out.println(Arrays.toString(cs.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}))); // [0,1,2,3] or [0,2,1,3]
    }
}


//Optimized to avoid reverse
class CourseScheduleIII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Graph: prerequisite -> list of courses that depend on it
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int dep = pre[1];
            graph.get(dep).add(course); // flip edge: dep → course
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        // Start DFS from courses with no prerequisites
        for (int course = 0; course < numCourses; course++) {
            if (!visited.contains(course)) {
                if (!dfs(course, graph, visited, visiting, result)) {
                    return new int[0]; // cycle detected → no valid order
                }
            }
        }

        // Convert result list to array
        int[] ordered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ordered[i] = result.get(i); // already in correct order
        }
        return ordered;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph,
                        Set<Integer> visited, Set<Integer> visiting,
                        List<Integer> result) {
        if (visiting.contains(course)) return false; // cycle detected
        if (visited.contains(course)) return true;   // already processed

        visiting.add(course);

        for (int next : graph.get(course)) {
            if (!dfs(next, graph, visited, visiting, result)) return false;
        }

        visiting.remove(course);
        visited.add(course);
        result.add(course); // safe to add: dependencies already handled
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();

//        System.out.println(Arrays.toString(cs.findOrder(2, new int[][]{{1, 0}})));           // [0, 1]
//        System.out.println(Arrays.toString(cs.findOrder(2, new int[][]{{1, 0}, {0, 1}})));   // []
//        System.out.println(Arrays.toString(cs.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}))); // [0,1,2,3]
    }
}
