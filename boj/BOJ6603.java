package boj;

public class BOJ6603 {
    static FastReader SC = new FastReader();
    static int K;
    static int[] S, SELECTED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            K = SC.nextInt();
            if (K == 0) {
                break;
            }

            S = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                S[i] = SC.nextInt();
            }
            SELECTED = new int[7];

            recFunc(1, 0, 6);
            SB.append('\n');
        }
        System.out.println(SB);
    }

    private static void recFunc(int k, int prevIdx, int maxLen) {
        if (k == maxLen + 1) {
            for (int i = 1; i <= 6; i++) {
                SB.append(SELECTED[i]).append(' ');
            }
            SB.append('\n');
        }
        else {
            for (int i = 1; i <= K; i++) {
                if (i > prevIdx) {
                    SELECTED[k] = S[i];
                    recFunc(k + 1, i, maxLen);
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
