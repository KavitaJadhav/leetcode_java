package patterns.graph.topological_sort;

import java.util.*;
public class CourseScheduleI {

    public int solve(int count, ArrayList<Integer> prerequisites, ArrayList<Integer> courses) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[count+1];

        for(int number = 1; number <= count; number++){
            map.put(number, new ArrayList<>());
        }

        for(int index = 0; index < prerequisites.size(); index++){
            int course = courses.get(index);
            int prerequisite = prerequisites.get(index);
            // System.out.print(course + " "+ prerequisite + ", ");

            map.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int index = 1; index <= count; index++){
            if(indegree[index]==0)
                queue.offer(index);
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            for(Integer dependentCourse : map.get(course)){
                indegree[dependentCourse]--;
                if(indegree[dependentCourse]==0){
                    queue.offer(dependentCourse);

                }
            }
        }

        // System.out.print("Hello");

        for(int index = 1; index <= count; index++){
            // System.out.print(indegree[index]+ " ");

            if(indegree[index]>0)
                return 0;
        }

        return 1;

    }
}
// 5
// [1,3,4,5]
// [2,1,5,3]
//  A = 3
//  B = [1, 2]
//  C = [2, 3]
// 2-1
// 3-2

