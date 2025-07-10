package boj;

import java.util.Arrays;

public class BOJ18110 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] LEVELS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        if (N == 0) {
            System.out.println(0);
            return;
        }

        int diff = (int) Math.round(N * 0.15);
        int start = diff;
        int end = N - diff - 1;

        Arrays.sort(LEVELS);
        double avg = 0.0;
        for (int i = start; i <= end; i++) {
            avg += (double) LEVELS[i];
        }
        avg /= (N - (diff * 2));

        System.out.println((int) Math.round(avg));
    }

    private static void input() {
        N = SC.nextInt();
        LEVELS = new int[N];
        for (int i = 0; i < N; i++) {
            LEVELS[i] = SC.nextInt();
        }
    }
}
