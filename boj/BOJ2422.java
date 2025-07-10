package boj;

import java.util.*;

public class BOJ2422 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static boolean[][] COMBINATION;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                if (COMBINATION[i][j] || COMBINATION[j][i]) {
                    continue;
                }
                for (int k = j + 1; k <= N; k++) {
                    if (COMBINATION[i][k] || COMBINATION[k][i] || COMBINATION[j][k]
                            || COMBINATION[k][j]) {
                        continue;
                    }
                    // System.out.println(i + " " + j + " " + k);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        COMBINATION = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            COMBINATION[n1][n2] = true;
            COMBINATION[n2][n1] = true;
        }
    }
}
