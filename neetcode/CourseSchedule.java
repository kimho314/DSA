package neetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();
        boolean res = sol.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        System.out.println(res);
        res = sol.canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1},
                {15, 1}, {17, 4}});
        System.out.println(res);
        res = sol.canFinish(2, new int[][]{{0, 1}, {1, 0}});
        System.out.println(res);
        res = sol.canFinish(2, new int[][]{{0, 1}});
        System.out.println(res);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] elem : prerequisites) {
            int a = elem[0];
            int b = elem[1];
            adj.get(b).add(a);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int elem : adj.get(i)) {
                inDegree[elem]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> plan = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            plan.add(node);

            for (int elem : adj.get(node)) {
                if (--inDegree[elem] == 0) {
                    q.add(elem);
                }
            }
        }

        return plan.size() == numCourses;
    }

}
