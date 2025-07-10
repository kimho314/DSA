package boj;

import java.util.*;

public class BOJ1654 {
    private static FastReader SC = new FastReader();
    private static int K, N;
    private static int[] CABLES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        K = SC.nextInt();
        N = SC.nextInt();
        CABLES = new int[K];
        for (int i = 0; i < K; i++) {
            CABLES[i] = SC.nextInt();
        }

    }

    private static void solve() {
        long max = Long.MIN_VALUE;
        long l = 0;
        long r = (long) Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                max = Math.max(max, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(max);
    }

    private static boolean check(long n) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += CABLES[i] / n;
        }
        return cnt >= N;
    }
}
