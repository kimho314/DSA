package boj;

import java.util.*;

public class BOJ15649 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] SELECTED;
    private static boolean[] USED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        SELECTED = new int[M];
        USED = new boolean[9];
    }

    private static void solve() {
        recFunc(0);
        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == M) {
            StringBuilder sb = new StringBuilder();
            for (int elem : SELECTED) {
                sb.append(elem).append(" ");
            }
            SB.append(sb).append("\n");

        } else {
            for (int i = 1; i <= N; i++) {
                if (!USED[i]) {
                    USED[i] = true;
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    USED[i] = false;
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
