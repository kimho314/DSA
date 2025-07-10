package boj;

import java.util.Arrays;

public class BOJ16112 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static long[] EXPS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(EXPS);

        long max = 0;
        int k = 0;
        for (int i = 0; i < N; i++) {
            max += EXPS[i] * k;
            if (k < K) {
                k++;
            }
        }

        System.out.println(max);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        EXPS = new long[N];
        for (int i = 0; i < N; i++) {
            EXPS[i] = SC.nextLong();
        }
    }
}
