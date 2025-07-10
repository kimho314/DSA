package boj;

import java.util.Arrays;

public class BOJ18429 {
    static FastReader SC = new FastReader();
    static int N, K;
    static int[] WEIGHTS, SELECTED;
    static boolean[] USED;
    static int INIT_WEIGHT = 500;
    static int CNT = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        SELECTED = new int[N + 1];
        WEIGHTS = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            WEIGHTS[i] = SC.nextInt();
        }
        USED = new boolean[N + 1];
        recFunc(1);
        System.out.println(CNT);
    }

    private static void recFunc(int k) {
        if (k == N + 1) {
            System.out.println(Arrays.toString(SELECTED));
            CNT++;
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (!USED[i] && isAvailable(WEIGHTS[i])) {
                    SELECTED[k] = WEIGHTS[i];
                    USED[i] = true;
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                    USED[i] = false;
                    INIT_WEIGHT = INIT_WEIGHT + K - WEIGHTS[i];
                }
            }
        }
    }

    private static boolean isAvailable(int weight) {
        int tmpWeight = INIT_WEIGHT - K + weight;
        if (tmpWeight >= 500) {
            INIT_WEIGHT = tmpWeight;
            return true;
        }
        else {
            return false;
        }
    }
}
