package boj;

import java.util.Arrays;

public class BOJ18353 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] SOLDIERS;
    static int[] DP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.fill(DP, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (SOLDIERS[j] > SOLDIERS[i]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        int max = DP[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, DP[i]);
        }

        System.out.println(N - max);
    }

    private static void input() {
        N = SC.nextInt();
        SOLDIERS = new int[N];
        for (int i = 0; i < N; i++) {
            SOLDIERS[i] = SC.nextInt();
        }
        DP = new int[N];
    }
}
