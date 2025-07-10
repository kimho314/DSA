package boj;

import java.util.Arrays;

public class BOJ15657 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int N, M;
    static int[] A;
    static int[] SELECTED;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N + 1];
        SELECTED = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
        Arrays.sort(A);
        recFunc(1);
        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                SB.append(SELECTED[i]).append(' ');
            }
            SB.append('\n');
        }
        else {
            for (int i = 1; i <= N; i++) {
                boolean isValid = true;
                for (int j = 1; j < k; j++) {
                    if (SELECTED[j] > A[i]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    SELECTED[k] = A[i];
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
