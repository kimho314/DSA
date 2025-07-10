package boj;

import java.util.*;

public class BOJ2798 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] CARDS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(CARDS);

        int res = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = CARDS[i] + CARDS[j] + CARDS[k];
                    if (sum <= M && Math.abs(M - sum) < Math.abs(M - res)) {
                        res = sum;
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        CARDS = new int[N];
        for (int i = 0; i < N; i++) {
            CARDS[i] = SC.nextInt();
        }
    }
}
