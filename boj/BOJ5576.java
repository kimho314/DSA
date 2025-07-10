package boj;

import java.util.Arrays;

public class BOJ5576 {
    private static FastReader SC = new FastReader();
    private static int[] W, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(W);
        Arrays.sort(K);

        int scoreW = 0;
        for (int i = 9; i >= 7; i--) {
            scoreW += W[i];
        }
        int scoreK = 0;
        for (int i = 9; i >= 7; i--) {
            scoreK += K[i];
        }

        System.out.println(scoreW + " " + scoreK);
    }

    private static void input() {
        W = new int[10];
        K = new int[10];
        for (int i = 0; i < 10; i++) {
            W[i] = SC.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            K[i] = SC.nextInt();
        }
    }
}
