package boj;

public class BOJ2670 {
    static FastReader SC = new FastReader();
    static int N;
    static double[] A, DP;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new double[N];
        DP = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextDouble();
        }

        DP[0] = A[0];
        for (int i = 1; i < N; i++) {
            DP[i] = Math.max(A[i], DP[i - 1] * A[i]);
        }

        double res = DP[0];
        for (int i = 1; i < N; i++) {
            res = Math.max(res, DP[i]);
        }
        System.out.printf("%.3f%n", res);
    }
}
