package boj;

import java.util.Arrays;

public class BOJ25305 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = SC.nextInt();
        }

        Arrays.sort(scores);
        int res = -1;
        for (int i = N - 1; i >= 0; i--) {
            K--;
            if (K == 0) {
                res = scores[i];
            }
        }
        System.out.println(res);
    }
}
