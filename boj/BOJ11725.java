package boj;

import java.util.*;

public class BOJ11725 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int[] PARENTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(PARENTS[i]);
        }
    }

    private static void dfs(int x) {
        VISITED[x] = true;

        for (int n : ADJ[x]) {
            if (!VISITED[n]) {
                PARENTS[n] = x;
                dfs(n);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        PARENTS = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
    }
}
