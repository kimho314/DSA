import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII sol = new CourseScheduleII();
        int[] res = sol.findOrder(3, new int[][] {{1, 0}});
        System.out.println(Arrays.toString(res));
        res = sol.findOrder(3, new int[][] {{0, 1}, {1, 2}, {2, 0}});
        System.out.println(Arrays.toString(res));
        res = sol.findOrder(3, new int[][] {{1, 2}});
        System.out.println(Arrays.toString(res));
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] elem : prerequisites) {
            int a = elem[0];
            int b = elem[1];
            adj.get(b).add(a);
        }

        List<Integer> order = topologicalSort(adj, numCourses);
        if (order.size() < numCourses) {
            return new int[0];
        } else {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = order.get(i);
            }
            return res;
        }
    }

    private List<Integer> topologicalSort(List<List<Integer>> adj, int numCourses) {
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

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);

            for (int next : adj.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return res;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] pair : prerequisites) {
            prereq.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, prereq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit,
            Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, prereq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
