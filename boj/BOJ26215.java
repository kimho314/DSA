package boj;

import java.util.Arrays;
import java.util.Collections;

public class BOJ26215 {
    static FastReader SC = new FastReader();
    static int N;
    static Integer[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        final int maxTime = 1440;
        int res = 0;
        Arrays.sort(A, Collections.reverseOrder());
        while (A[0] > 0) {
            if (A.length > 1) {
                A[0]--;
                if (A[1] > 0) {
                    A[1]--;
                }
            }
            else {
                A[0]--;
            }

            res++;
            Arrays.sort(A, Collections.reverseOrder());
        }

        if (res > maxTime) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }

    private static void input() {
        N = SC.nextInt();
        A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
