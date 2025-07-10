package boj;

import java.util.*;

public class BOJ15654 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static boolean[] USED;
    private static int[] SELECTED, NUMS;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        USED = new boolean[N];
        SELECTED = new int[M];
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
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
            for (int i = 0; i < N; i++) {
                if (!USED[i]) {
                    USED[i] = true;
                    SELECTED[k] = NUMS[i];
                    recFunc(k + 1);
                    USED[i] = false;
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
