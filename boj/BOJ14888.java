package boj;

import java.util.*;

public class BOJ14888 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;
    private static int[] CNT;
    private static int[] SELECTED;
    private static int MIN, MAX;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        CNT = new int[4];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            CNT[i] = SC.nextInt();
        }
        SELECTED = new int[N - 1];
        MIN = Integer.MAX_VALUE;
        MAX = Integer.MIN_VALUE;
    }

    private static void solve() {
        recFunc(0);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void recFunc(int k) {
        if (k == N - 1) {
            int sum = A[0];
            for (int i = 0; i < N - 1; i++) {
                if (SELECTED[i] == 0) {
                    sum += A[i + 1];
                } else if (SELECTED[i] == 1) {
                    sum -= A[i + 1];
                } else if (SELECTED[i] == 2) {
                    sum *= A[i + 1];
                } else {
                    sum /= A[i + 1];
                }
            }
            // System.out.println(Arrays.toString(SELECTED));
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if (CNT[i] > 0) {
                    CNT[i]--;
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    CNT[i]++;
                    SELECTED[k] = -1;
                }
            }
        }
    }
}
