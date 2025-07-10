package boj;

import java.util.Arrays;

public class BOJ14467 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] COWS;
    private static int[] CNT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(COWS, -1);
        for (int i = 0; i < N; i++) {
            int n1 = SC.nextInt();
            int n2 = SC.nextInt();
            if (COWS[n1] != -1 && n2 != COWS[n1]) {
                CNT[n1]++;
            }
            COWS[n1] = n2;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += CNT[i];
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        COWS = new int[N + 1];
        CNT = new int[N + 1];
    }
}
