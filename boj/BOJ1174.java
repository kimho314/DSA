package boj;

import java.util.*;

public class BOJ1174 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int CNT;
    private static long RES;
    private static int[] SELECTED;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        RES = -1;
        CNT = 0;
        SELECTED = new int[10];
    }

    private static void solve() {
        for (int i = 1; i <= 10; i++) {
            recFunc(0, i);
        }

        System.out.println(RES);
    }

    private static void recFunc(int k, int len) {
        if (k == len) {
            CNT++;
            long num = 0;
            int t = 1;
            for (int i = len - 1; i >= 0; i--) {
                num += (long) SELECTED[i] * (long) t;
                t *= 10;
            }
            // System.out.println(
            // k + " " + len + " " + CNT + " " + num + " " + Arrays.toString(SELECTED));
            if (CNT == N) {
                RES = num;
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (k == 0 || i < SELECTED[k - 1]) {
                    SELECTED[k] = i;
                    recFunc(k + 1, len);
                    SELECTED[k] = -1;
                }
            }
        }
    }
}
