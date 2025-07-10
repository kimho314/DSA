package boj;

import java.util.ArrayList;

public class BOJ2606 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer>[] ADJ;
    private static boolean[] VISITED;
    private static int CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        dfs(1);
        System.out.println(CNT);
    }

    private static void dfs(int x) {
        VISITED[x] = true;
        for (int n : ADJ[x]) {
            if (!VISITED[n]) {
                CNT++;
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
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            ADJ[n1].add(n2);
            ADJ[n2].add(n1);
        }
        VISITED = new boolean[N + 1];
        CNT = 0;
    }
}
