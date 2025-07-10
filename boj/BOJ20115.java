package boj;

import java.util.*;

public class BOJ20115 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static double[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        A = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextDouble();
        }
    }

    private static void solve() {
        Arrays.sort(A);

        double sum = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (sum >= A[i]) {
                sum = sum + (A[i] / 2.0);
            } else {
                sum = A[i] + (sum / 2.0);
            }
            // System.out.println(i + " " + sum);
        }
        System.out.println(sum);
    }
}
