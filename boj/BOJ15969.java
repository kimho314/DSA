package boj;

import java.util.Arrays;

public class BOJ15969 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        Arrays.sort(A);
        int min = A[0];
        int max = A[N - 1];

        System.out.println(max - min);
    }
}
