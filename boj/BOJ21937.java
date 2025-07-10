package boj;

import java.util.*;

public class BOJ21937 {
    private static FastReader SC = new FastReader();
    private static int N, M, X;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(X);

        System.out.println(CNT - 1);
    }

    private static void dfs(int x) {
        VISITED[x] = true;
        CNT++;

        for (int n : ADJ[x]) {
            if (!VISITED[n]) {
                dfs(n);
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
        VISITED = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n2].add(n1);
        }
        X = SC.nextInt();
        CNT = 0;
    }
}
