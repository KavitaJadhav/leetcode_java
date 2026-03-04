//Complexity
//Time: O(V + E) — Each node is visited once, each edge once.
//Space: O(V + E) — For adjacency list + recursion stack + sets.
//https://leetcode.com/problems/course-schedule/description/
package graph;

import java.util.*;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDependencyMap = new HashMap<>();
        Set<Integer> visited_courses = new HashSet<>();
        Set<Integer> visiting_courses = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            courseDependencyMap.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            courseDependencyMap.get(pre[0]).add(pre[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!visited_courses.contains(course)) {
                if (!dfs(course, courseDependencyMap, visited_courses, visiting_courses)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> courseDependencyMap, Set<Integer> visitedCourses, Set<Integer> visitingCourses) {
        if (visitedCourses.contains(course)) {
            return true;
        }
        if (visitingCourses.contains(course)) {
            return false;
        }

        visitingCourses.add(course);
        for (int dependency : courseDependencyMap.get(course)) {
            if (!dfs(dependency, courseDependencyMap, visitedCourses, visitingCourses)) {
                return false;
            }

        }
        visitingCourses.remove(course);
        visitedCourses.add(course);
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleI courseScheduleI = new CourseScheduleI();
        System.out.println(courseScheduleI.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(courseScheduleI.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
