package boj;

import java.util.*;

public class BOJ2512 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] PRICE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        PRICE = new int[N];
        for (int i = 0; i < N; i++) {
            PRICE[i] = SC.nextInt();
        }
        M = SC.nextInt();
    }

    private static void solve() {
        int res = 0;
        int l = 1;
        int r = PRICE[0];
        for (int i = 1; i < N; i++) {
            if (r < PRICE[i]) {
                r = PRICE[i];
            }
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (determin(mid)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(res);
    }

    private static boolean determin(int limit) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (limit <= PRICE[i]) {
                sum += limit;
            } else {
                sum += PRICE[i];
            }
        }
        return sum <= M;
    }
}
