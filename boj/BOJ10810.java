package boj;

import java.util.Arrays;

public class BOJ10810 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] BALLS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int cnt = 0; cnt < M; cnt++) {
            int i = SC.nextInt();
            int j = SC.nextInt();
            int k = SC.nextInt();

            Arrays.fill(BALLS, i, j + 1, k);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(BALLS[i] + " ");
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();

        BALLS = new int[N + 1];
    }
}
