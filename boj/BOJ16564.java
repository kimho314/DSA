package boj;

import java.util.Arrays;

public class BOJ16564 {
    static FastReader SC = new FastReader();
    static int N, K;
    static Integer[] X;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(X);
        int l = X[0];
        int r = X[0] + K;

        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (determine(mid)) {
                l = mid + 1;
                res = mid;
            }
            else {
                r = mid - 1;
            }
        }
        System.out.println(res);
    }

    private static boolean determine(int mid) {
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (mid - X[i] > 0) {
                cnt += (mid - X[i]);
            }
        }
        return cnt <= K;
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        X = new Integer[N];
        for (int i = 0; i < N; i++) {
            X[i] = SC.nextInt();
        }
    }
}
