package boj;

import java.util.*;

public class BOJ15665 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] NUMS;
    private static int[] SELECTED;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
        SELECTED = new int[M];
    }

    private static void solve() {
        Arrays.sort(NUMS);

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
            int prev = 0;
            for (int i = 0; i < N; i++) {
                if (prev != NUMS[i]) {
                    prev = NUMS[i];
                    SELECTED[k] = NUMS[i];
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
