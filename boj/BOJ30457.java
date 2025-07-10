package boj;

import java.util.Arrays;

public class BOJ30457 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int t = 2;
        int res = 0;

        Arrays.sort(A);

        while (t > 0) {
            t--;

            int prev = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] != -1 && A[i] > prev) {
                    res++;
                    prev = A[i];
                    A[i] = -1;
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
