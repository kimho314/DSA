package boj;

import java.util.Arrays;

public class BOJ1337 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        int minCnt = 4;

        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            int l = i;
            int r = N - 1;
            while (l < r) {
                if (A[r] - A[l] > 4) {
                    r--;
                }
                else {
                    int cnt = 4 - (r - l);
                    minCnt = Math.min(minCnt, cnt);
                    break;
                }
            }
        }

        System.out.println(minCnt);
    }
}
