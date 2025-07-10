package boj;

import java.util.Arrays;

public class BOJ1026 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A, B;
    static int SUM = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N + 1];
        B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            B[i] = SC.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 1; i <= N; i++) {
            SUM += (A[i] * B[N - i + 1]);
        }

        System.out.println(SUM);
    }

}
