package boj;

import java.util.*;

public class BOJ15656 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] A;
    private static int[] SELECTED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        SELECTED = new int[M];
    }

    private static void solve() {
        Arrays.sort(A);

        recFunc(0);

        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == M) {
            for (int elem : SELECTED) {
                SB.append(elem).append(" ");
            }
            SB.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                SELECTED[k] = A[i];
                recFunc(k + 1);
                SELECTED[k] = 0;
            }
        }
    }
}
