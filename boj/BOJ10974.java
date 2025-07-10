package boj;

public class BOJ10974 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] SELECTED;
    static boolean[] USED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        SELECTED = new int[N + 1];
        USED = new boolean[N + 1];

        recFunc(1);
        System.out.println(SB);
    }

    private static void recFunc(int k) {
        if (k == N + 1) {
            for (int i = 1; i <= N; i++) {
                SB.append(SELECTED[i]).append(' ');
            }
            SB.append('\n');
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (!USED[i]) {
                    SELECTED[k] = i;
                    USED[i] = true;
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                    USED[i] = false;
                }
            }
        }
    }
}
