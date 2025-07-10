package boj;

import java.util.Arrays;

public class BOJ1246 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] P;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        P = new int[M];
        for (int i = 0; i < M; i++) {
            P[i] = SC.nextInt();
        }

        Arrays.sort(P);

        int finalPrice = 0;
        int res = 0;
        int min = P[0];
        int max = P[M - 1];
        for (int i = min; i <= max; i++) {
            int cnt = 0;
            int totalPrice = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (cnt >= N) {
                    break;
                }

                if (P[j] >= i) {
                    cnt++;
                }
            }

            totalPrice = i * cnt;
            if (res < totalPrice) {
                res = totalPrice;
                finalPrice = i;
            }
        }

        System.out.println(finalPrice + " " + res);
    }
}
