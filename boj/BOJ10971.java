package boj;

import java.util.*;

public class BOJ10971 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] W;
    private static boolean[] VISITED;
    private static int MIN;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        W = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                W[i][j] = SC.nextInt();
            }
        }
        VISITED = new boolean[N + 1];
        MIN = Integer.MAX_VALUE;
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(VISITED, false);
            VISITED[0] = true;
            VISITED[i] = true;
            recFunc(i, 0, i, 0, 0);
        }

        System.out.println(MIN);
    }

    private static void recFunc(int origin, int from, int to, int k, int sum) {
        // System.out.println(origin + " " + from + " " + to + " " + sum);
        if (k == N - 1) {
            if (W[to][origin] == 0) {
                return;
            }
            sum += W[to][origin];
            // System.out.println(sum + " " + MIN);
            MIN = Math.min(MIN, sum);
        } else {
            for (int i = 1; i <= N; i++) {
                if (W[to][i] != 0 && !VISITED[i]) {
                    VISITED[i] = true;
                    recFunc(origin, to, i, k + 1, sum + W[to][i]);
                    VISITED[i] = false;
                }
            }
        }
    }
}
