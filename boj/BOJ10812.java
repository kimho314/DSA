package boj;

import java.util.Arrays;

public class BOJ10812 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] BASKETS;

    public static void main(String[] args) {
        input();

        for (int cnt = 0; cnt < M; cnt++) {
            int i = SC.nextInt();
            int j = SC.nextInt();
            int k = SC.nextInt();

            solve(i - 1, j - 1, k - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : BASKETS) {
            sb.append(num).append(' ');
        }
        System.out.println(sb.toString());
    }


    private static void solve(int start, int end, int mid) {
        int[] arr = Arrays.copyOfRange(BASKETS, start, mid);
        int i = 0;
        for (i = 0; i < end - mid + 1; i++) {
            BASKETS[i + start] = BASKETS[mid + i];
        }

        for (int k : arr) {
            BASKETS[start + i++] = k;
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        BASKETS = new int[N];
        for (int i = 0; i < N; i++) {
            BASKETS[i] = i + 1;
        }
    }
}
