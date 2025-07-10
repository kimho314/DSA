package boj;

import java.util.Arrays;

public class BOJ2428 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] SIZES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(SIZES);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int upperBound = searchUpperBound(i);
            if (upperBound == -1) {
                continue;
            }
            sum += upperBound - i;
        }
        System.out.println(sum);
    }

    private static int searchUpperBound(int idx) {
        int l = idx + 1;
        int r = N - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (determine(mid, idx)) {
                res = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return res;
    }


    private static boolean determine(int mid, int idx) {
        return (SIZES[mid] >= SIZES[idx]) && ((double) SIZES[mid] * 0.9 <= (double) SIZES[idx]);
    }

    private static void input() {
        N = SC.nextInt();
        SIZES = new int[N];
        for (int i = 0; i < N; i++) {
            SIZES[i] = SC.nextInt();
        }
    }
}
