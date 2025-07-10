package boj;

import java.util.*;

public class BOJ15651 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] SELECTED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        SELECTED = new int[M];
    }

    private static void solve() {
        recFunc(0);
        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == M) {
            for (int n : SELECTED) {
                SB.append(n).append(" ");
            }
            SB.append("\n");

        } else {
            for (int i = 1; i <= N; i++) {
                SELECTED[k] = i;
                recFunc(k + 1);
                SELECTED[k] = 0;
            }
        }
    }
}
