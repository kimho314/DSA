package boj;

import java.util.*;

public class BOJ2805 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] H;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = SC.nextInt();
        }
    }

    private static void solve() {
        long res = 0;
        long l = 0;
        long r = 1_000_000_000;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (check(mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean check(long h) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (H[i] > h) {
                sum += (H[i] - h);
            }
        }
        return sum >= M;
    }
}
