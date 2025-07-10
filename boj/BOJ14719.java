package boj;

import java.util.*;

public class BOJ14719 {
    private static FastReader SC = new FastReader();
    private static int H, W;
    private static int[] WATER;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        H = SC.nextInt();
        W = SC.nextInt();
        WATER = new int[W];
        for (int i = 0; i < W; i++) {
            WATER[i] = SC.nextInt();
        }
    }

    private static void solve() {
        int res = 0;

        for (int i = 1; i < W - 1; i++) {
            int right = i;
            for (int j = i + 1; j < W; j++) {
                if (WATER[right] < WATER[j]) {
                    right = j;
                }
            }
            int left = i;
            for (int j = 0; j < i; j++) {
                if (WATER[left] < WATER[j]) {
                    left = j;
                }
            }

            if (right != i && left != i) {
                int sum = Math.min(WATER[left], WATER[right]) - WATER[i];
                res += sum;
            }
        }

        System.out.println(res);
    }
}
