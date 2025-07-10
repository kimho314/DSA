package boj;

import java.util.Arrays;

public class BOJ1449 {
    static FastReader SC = new FastReader();
    static int N, L;
    static double[] LEAKS;

    public static void main(String[] args) {
        N = SC.nextInt();
        L = SC.nextInt();
        LEAKS = new double[N];
        for (int i = 0; i < N; i++) {
            LEAKS[i] = SC.nextInt();
        }

        Arrays.sort(LEAKS);
        double start = LEAKS[0] - 0.5;
        double end = start + (double) L;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            double tmpStart = LEAKS[i] - 0.5;
            double tmpEnd = LEAKS[i] + 0.5;
            if (end <= tmpStart || end < tmpEnd) {
                end = tmpStart + (double) L;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
