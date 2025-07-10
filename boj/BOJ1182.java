package boj;

import java.util.*;

public class BOJ1182 {
    private static FastReader SC = new FastReader();
    private static int N, S;
    private static int[] NUMS, SELECTED;
    private static int CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        S = SC.nextInt();
        NUMS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMS[i] = SC.nextInt();
        }
        CNT = 0;
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            SELECTED = new int[i];
            recFunc(-1, 0, i);
        }

        System.out.println(CNT);
    }

    private static void recFunc(int prev, int k, int len) {
        if (k == len) {
            int sum = 0;
            for (int elem : SELECTED) {
                sum += elem;
            }
            if (sum == S) {
                CNT++;
            }
        } else {
            for (int i = prev + 1; i < N; i++) {
                SELECTED[k] = NUMS[i];
                recFunc(i, k + 1, len);
                SELECTED[k] = Integer.MIN_VALUE;
            }
        }
    }
}
