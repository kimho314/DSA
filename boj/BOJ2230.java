package boj;

import java.util.Arrays;

public class BOJ2230 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        Arrays.sort(A);
        int res = Integer.MAX_VALUE;
        int r = 0;
        for (int l = 0; l < N; l++) {
            while (r < N) {
                int diff = A[r] - A[l];
                if (diff >= M) {
                    res = Math.min(res, diff);
                    break;
                }
                r++;
            }
        }
        System.out.println(res);
    }
}
