package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2252 {
    private static FastReader SC = new FastReader();
    private static int M, N;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            adj.get(n1 - 1).add(n2 - 1);
        }

//        for (int i = 0; i < N; i++) {
//            List<Integer> list = adj.get(i);
//            StringBuilder sb = new StringBuilder();
//            for (int elem : list) {
//                sb.append(elem + 1).append(" ");
//            }
//            IO.println((i + 1) + " " + sb);
//        }

        List<Integer> res = topologicalSort(adj);
        for (int elem : res) {
            System.out.print(elem + " ");
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
            res.add(node + 1);

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
