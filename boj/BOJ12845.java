package boj;

import java.util.Arrays;

public class BOJ12845 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] L;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(L);

        int max = L[N - 1];
        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            res += (max + L[i]);
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = SC.nextInt();
        }
    }
}
