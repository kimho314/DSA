package boj;

import java.util.*;

public class BOJ11724 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<Integer> group = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i]) {
                dfs(i);
                group.add(i);
            }
        }

        System.out.println(group.size());
    }

    private static void dfs(int n) {
        VISITED[n] = true;
        for (int x : ADJ[n]) {
            if (!VISITED[x]) {
                VISITED[x] = true;
                dfs(x);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        VISITED = new boolean[N + 1];

    }
}
