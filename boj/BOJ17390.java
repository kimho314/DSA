package boj;

import java.util.Arrays;

public class BOJ17390 {
    private static FastReader SC = new FastReader();
    private static int N, Q;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(A);
        int[] s = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            s[i] = A[i - 1] + s[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (Q > 0) {
            Q--;

            int l = SC.nextInt();
            int r = SC.nextInt();
            int sum = s[r] - s[l - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        Q = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
