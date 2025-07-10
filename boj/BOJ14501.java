package boj;

import java.util.*;

public class BOJ14501 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j][0] <= i) {
                    dp[i] = Math.max(dp[i], dp[j] + A[j][1]);
                }
            }
        }

        System.out.println(dp[N + 1]);
    }



    private static void input() {
        N = SC.nextInt();
        A = new int[N + 2][2];
        for (int i = 1; i <= N; i++) {
            int t = SC.nextInt();
            int p = SC.nextInt();
            A[i][0] = t;
            A[i][1] = p;
        }

    }
}
