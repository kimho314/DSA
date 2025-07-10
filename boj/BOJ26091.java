package boj;

import java.util.Arrays;

public class BOJ26091 {
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
        int cnt = 0;
        if (N >= 2) {
            int l = 0;
            int r = N - 1;
            while (l < r) {
                if (A[l] + A[r] >= M) {
                    r--;
                    cnt++;
                }
                l++;
            }
        }

        System.out.println(cnt);
    }
}
