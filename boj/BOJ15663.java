package boj;

import java.util.*;

public class BOJ15663 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] SELECTED;
    private static int[] NUMS;
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
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
        USED = new boolean[N];
    }

    private static void solve() {
        Arrays.sort(NUMS);

        recFunc(0);

        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == M) {
            // System.out.println(Arrays.toString(SELECTED));
            for (int elem : SELECTED) {
                SB.append(elem).append(" ");
            }
            SB.append("\n");
        } else {
            int prev = 0;
            for (int i = 0; i < N; i++) {
                if (prev != NUMS[i] && !USED[i]) {
                    SELECTED[k] = NUMS[i];
                    USED[i] = true;
                    prev = NUMS[i];

                    recFunc(k + 1);

                    SELECTED[k] = 0;
                    USED[i] = false;
                }
            }
        }
    }
}
