package boj;

import java.util.Arrays;

public class BOJ2012 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] ORDERS;

    public static void main(String[] args) {
        N = SC.nextInt();
        ORDERS = new int[N];
        for (int i = 0; i < N; i++) {
            ORDERS[i] = SC.nextInt();
        }
        Arrays.sort(ORDERS);

        long res = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (ORDERS[i] != cnt) {
                int diff = cnt - ORDERS[i];
                ORDERS[i] += diff;
                res += Math.abs(diff);
            }
            cnt++;
        }

        System.out.println(res);
    }
}
