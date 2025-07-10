package boj;

public class BOJ14889 {
    static FastReader SC = new FastReader();
    static int N;
    static int[][] S;
    static int[] SELECTED;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();
        SELECTED = new int[N / 2 + 1];
        S = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                S[i][j] = SC.nextInt();
            }
        }

        recFunc(1);
        System.out.println(MIN);
    }

    private static void recFunc(int k) {
        if (k == N / 2 + 1) {
            int sum1 = 0, sum2 = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }

                    boolean match1 = false;
                    boolean match2 = false;
                    for (int cnt = 1; cnt < SELECTED.length; cnt++) {
                        if (SELECTED[cnt] == i) {
                            match1 = true;
                        }
                        if (SELECTED[cnt] == j) {
                            match2 = true;
                        }
                    }
                    if (match1 && match2) {
                        sum1 += S[i][j];
                    }
                    if (!match1 && !match2) {
                        sum2 += S[i][j];
                    }
                }
            }
            int diff = Math.abs(sum1 - sum2);
//            System.out.println(Arrays.toString(Arrays.copyOfRange(SELECTED, 1, N / 2 + 1)) + " " + diff);
            MIN = Math.min(MIN, diff);
        }
        else {
            for (int i = SELECTED[k - 1] + 1; i <= N; i++) {
                SELECTED[k] = i;
                recFunc(k + 1);
                SELECTED[k] = 0;
            }
        }
    }
}
