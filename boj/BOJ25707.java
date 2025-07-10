package boj;

import java.util.Arrays;

public class BOJ25707 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] BEADS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(BEADS);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                res += Math.abs(BEADS[i] - BEADS[0]);
            } else {
                res += Math.abs(BEADS[i] - BEADS[i + 1]);
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        BEADS = new int[N];
        for (int i = 0; i < N; i++) {
            BEADS[i] = SC.nextInt();
        }
    }
}
