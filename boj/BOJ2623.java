package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2623 {
    private static FastReader SC = new FastReader();
    private static int N, M;

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        N = SC.nextInt();
        M = SC.nextInt();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] split = SC.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            if (n <= 0) {
                continue;
            }

            int cur = Integer.parseInt(split[1]);
            for (int j = 2; j <= n; j++) {
                int next = Integer.parseInt(split[j]);
                adj.get(cur - 1).add(next - 1);
                cur = next;
            }
        }

        List<Integer> res = topologicalSort(adj);
        if (res.size() < N) {
            System.out.println(0);
        }
        else {
            for (int elem : res) {
                System.out.println(elem + 1);
            }
        }
    }

    private static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int elem : adj.get(i)) {
                inDegree[elem]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int elem : adj.get(node)) {
                inDegree[elem]--;
                if (inDegree[elem] == 0) {
                    q.add(elem);
                }
            }
        }

        return res;
    }
}
