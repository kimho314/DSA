package neetcode;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();
        int[] res = sol.findOrder(3, new int[][]{{1, 0}});
        System.out.println(Arrays.toString(res));
        res = sol.findOrder(3, new int[][]{{0, 1}, {1, 2}, {2, 0}});
        System.out.println(Arrays.toString(res));
        res = sol.findOrder(3, new int[][]{{1, 2}});
        System.out.println(Arrays.toString(res));
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        if (plan.size() != numCourses) {
            return new int[0];
        }
        else {
            int[] res = new int[plan.size()];
            for (int i = 0; i < plan.size(); i++) {
                res[i] = plan.get(i);
            }
            return res;
        }
    }


}
