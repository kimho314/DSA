package boj;

import java.util.Arrays;

public class BOJ15664 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] SELECTED, A;
    static boolean[] USED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        SELECTED = new int[M + 1];
        USED = new boolean[N + 1];
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
        Arrays.sort(A);

        recFunc(1, 1);
        System.out.println(SB);
    }

    private static void recFunc(int k, int start) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                SB.append(SELECTED[i]).append(' ');
            }
            SB.append('\n');
        }
        else {
            int used = 0;
            for (int i = start; i <= N; i++) {
                if (used == A[i] || USED[i]) {
                    continue;
                }
                used = A[i];
                USED[i] = true;
                SELECTED[k] = A[i];
                recFunc(k + 1, i);
                SELECTED[k] = 0;
                USED[i] = false;
            }
        }
    }
}
