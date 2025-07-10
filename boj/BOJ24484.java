package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ24484 {
    static FastReader SC = new FastReader();
    static int N, M, R, CNT = 0;
    static ArrayList<Integer>[] ADJ;
    static boolean[] VISITED;
    static int[] D, T;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        R = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = SC.nextInt();
            int v = SC.nextInt();
            ADJ[u].add(v);
            ADJ[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            ADJ[i].sort(Comparator.reverseOrder());
        }
        VISITED = new boolean[N + 1];
        D = new int[N + 1];
        Arrays.fill(D, -1);
        T = new int[N + 1];

        dfs(R, 0);

        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += ((long) D[i] * (long) T[i]);
        }
        System.out.println(res);
    }

    private static void dfs(int node, int depth) {
        VISITED[node] = true;
        D[node] = depth;
        T[node] = ++CNT;

        for (Integer x : ADJ[node]) {
            if (VISITED[x]) {
                continue;
            }

            dfs(x, depth + 1);
        }
    }
}
