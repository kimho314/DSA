package boj;

import java.util.*;
import java.io.*;

public class BOJ2217 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] W;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = SC.nextInt();
        }
    }

    private static void solve() {
        Arrays.sort(W);

        int res = 0;
        int cnt = N;
        for (int i = 0; i < N; i++) {
            int sum = W[i] * cnt--;
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
