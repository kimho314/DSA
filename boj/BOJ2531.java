package boj;

import java.util.Arrays;

public class BOJ2531 {
    private static FastReader SC = new FastReader();
    private static int N, D, K, C;
    private static int[] SUSHI;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] check = new int[D + 1];
        int res = 0;
        for (int i = 0; i < N; i++) {
            int dupCount = 0;
            int coupon = 1;
            for (int j = i; j < i + K; j++) {
                if (check[SUSHI[j % N]] == 1) {
                    dupCount++;
                }
                else {
                    check[SUSHI[j % N]] = 1;
                }

                if (SUSHI[j % N] == C) {
                    coupon = 0;
                }
            }

            res = Math.max(res, K - dupCount + coupon);
            Arrays.fill(check, 0);
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        D = SC.nextInt();
        K = SC.nextInt();
        C = SC.nextInt();

        SUSHI = new int[N];
        for (int i = 0; i < N; i++) {
            SUSHI[i] = SC.nextInt();
        }
    }
}
