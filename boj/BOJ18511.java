package boj;

import java.util.*;

public class BOJ18511 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static int[] NUMS;
    private static int RES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int len = String.valueOf(N).length();

        for (int i = len; i > 0; i--) {
            recFunc("", i);
            if (RES > 0) {
                break;
            }
        }

        System.out.println(RES);
    }

    private static void recFunc(String str, int limit) {
        if (str.length() == limit) {
            if (Integer.parseInt(str) <= N) {
                RES = Math.max(RES, Integer.parseInt(str));
            }
        } else {
            for (int i = 0; i < K; i++) {
                recFunc(str + NUMS[i], limit);
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        NUMS = new int[K];
        for (int i = 0; i < K; i++) {
            NUMS[i] = SC.nextInt();
        }
        RES = 0;
    }
}
