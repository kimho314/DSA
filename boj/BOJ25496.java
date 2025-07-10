package boj;

import java.util.Arrays;

public class BOJ25496 {
    static FastReader SC = new FastReader();
    static int P, N;
    static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(A);

        int limit = P;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (limit < 200) {
                cnt++;
                limit += A[i];
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        P = SC.nextInt();
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
