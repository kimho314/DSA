package boj;

import java.util.Arrays;

public class BOJ20044 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] W;

    public static void main(String[] args) {
        N = SC.nextInt();
        W = new int[2 * N];
        for (int i = 0; i < W.length; i++) {
            W[i] = SC.nextInt();
        }
        Arrays.sort(W);
        int[] S = new int[N];

        for (int i = 0; i < W.length / 2; i++) {
            S[i] = W[i] + W[2 * N - i - 1];
        }
        Arrays.sort(S);
        System.out.println(S[0]);
    }
}
