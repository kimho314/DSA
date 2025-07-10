package boj;

import java.util.*;

public class BOJ11508 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(C);

        int res = 0;
        for (int i = N - 1; i >= 0; i -= 3) {
            res += C[i];
            if (i - 1 >= 0) {
                res += C[i - 1];
            }
        }
        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = SC.nextInt();
        }
    }
}
