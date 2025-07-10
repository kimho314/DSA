package boj;

import java.util.Arrays;

public class BOJ10819 {
    static FastReader SC = new FastReader();
    static int[] A;
    static boolean[] USED;
    static int[] SELECTED;
    static int N;
    static int ANS;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N + 1];
        USED = new boolean[N + 1];
        SELECTED = new int[N + 1];
        Arrays.fill(SELECTED, Integer.MIN_VALUE);
        for (int i = 1; i <= N; i++) {
            A[i] = SC.nextInt();
        }
        ANS = Integer.MIN_VALUE;
        recFunc(1);
        System.out.println(ANS);
    }

    private static void recFunc(int k) {
        if (k == N + 1) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(SELECTED[i] - SELECTED[i + 1]);
            }
            System.out.println(Arrays.toString(Arrays.copyOfRange(SELECTED, 1, SELECTED.length)) + " : " + sum);
            ANS = Math.max(ANS, sum);
        }
        else {
            for (int i = 1; i <= N; i++) {
                boolean isUsed = false;
                for (int j = 1; j < k; j++) {
                    if (SELECTED[j] == A[i] && USED[i]) {
                        isUsed = true;
                        break;
                    }
                }
                if (!isUsed) {
                    SELECTED[k] = A[i];
                    USED[i] = true;
                    recFunc(k + 1);
                    SELECTED[k] = Integer.MAX_VALUE;
                    USED[i] = false;
                }
            }
        }
    }
}
