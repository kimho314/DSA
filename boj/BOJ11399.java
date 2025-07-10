package boj;

import java.util.*;

public class BOJ11399 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] P;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(P);
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += (P[i] * (N - i));
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = SC.nextInt();
        }
    }
}
