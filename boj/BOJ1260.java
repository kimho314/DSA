package boj;

import java.util.*;

public class BOJ1260 {
    private static FastReader SC = new FastReader();
    private static int N, M, V;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static StringBuilder SB1, SB2;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(V);
        Arrays.fill(VISITED, false);
        bfs(V);

        System.out.println(SB1);
        System.out.println(SB2);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        VISITED[start] = true;
        SB2.append(start).append(" ");

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int n : ADJ[x]) {
                if (!VISITED[n]) {
                    VISITED[n] = true;
                    SB2.append(n).append(" ");
                    q.add(n);
                }
            }
        }
    }

    private static void dfs(int x) {
        VISITED[x] = true;
        SB1.append(x).append(" ");
        for (int n : ADJ[x]) {
            if (!VISITED[n]) {
                VISITED[n] = true;
                dfs(n);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        V = SC.nextInt();
        ADJ = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            ADJ[i] = new ArrayList<>();
        }
        VISITED = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(ADJ[i]);
        }
        SB1 = new StringBuilder();
        SB2 = new StringBuilder();
    }
}
