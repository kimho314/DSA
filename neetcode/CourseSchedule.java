import java.util.*;

public class CourseSchedule {
    private boolean res;
    private boolean[] visited;

    // Map each course to its prerequisites
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    // Store all courses along the current DFS path
    private Set<Integer> visiting = new HashSet<>();

    public static void main(String[] args) {
        CourseSchedule sol = new CourseSchedule();
        boolean res = sol.canFinish(5, new int[][] {{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        System.out.println(res);
        res = sol.canFinish(20, new int[][] {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1},
                {15, 1}, {17, 4}});
        System.out.println(res);
        res = sol.canFinish(2, new int[][] {{0, 1}, {1, 0}});
        System.out.println(res);
        res = sol.canFinish(2, new int[][] {{0, 1}});
        System.out.println(res);
    }

    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            adj.get(a).add(b);
        }

        List<Integer> res = topologicalSort(numCourses, adj);
        if (res.size() < numCourses) {
            return false;
        } else {
            return true;
        }
    }

    private List<Integer> topologicalSort(int numCourses, List<List<Integer>> adj) {
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

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs2(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs2(int crs) {
        if (visiting.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visiting.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs2(pre)) {
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }
        res = true;

        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }


        for (int i = 0; i < numCourses; i++) {
            visited = new boolean[numCourses];
            dfs(i, adj);
            // System.out.println(i + " " + res);
            if (!res) {
                break;
            }
        }


        return res;
    }

    private void dfs(int x, List<Integer>[] adj) {
        for (int elem : adj[x]) {
            if (visited[elem]) {
                res = false;
                return;
            }
            visited[elem] = true;
            dfs(elem, adj);
            visited[elem] = false;
        }
    }
}
