package boj;

import java.util.*;

public class BOJ2470 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] W;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = SC.nextInt();
        }
    }

    private static void solve() {
        Arrays.sort(W);

        int res = 2_000_000_000;
        int l = 0;
        int r = N - 1;
        String s = null;
        while (l < r) {
            int sum = W[l] + W[r];
            // System.out.println(l + " " + r + " " + sum + " " + res);
            if (res > Math.abs(sum)) {
                res = Math.abs(sum);
                s = W[l] + " " + W[r];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(s);
    }
}
