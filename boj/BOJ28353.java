package boj;

import java.util.Arrays;

public class BOJ28353 {
    static FastReader SC = new FastReader();
    static int N, K;
    static int[] W;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        W = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = SC.nextInt();
        }

        Arrays.sort(W);
        int res = 0;
        int l = 0;
        int r = N - 1;
        while (l < r) {
            for (int i = r; i > l; i--) {
                if (W[i] + W[l] <= K) {
                    System.out.println(W[l] + " " + W[i]);
                    r = i - 1;
                    res++;
                    break;
                }
            }
            l++;
        }
        System.out.println(res);
    }
}
