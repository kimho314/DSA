package boj;

public class BOJ2563 {
    private static final int LENGTH = 10;
    private static FastReader SC = new FastReader();
    private static int CNT;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < CNT; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();

            for (int j = y; j < y + LENGTH; j++) {
                for (int k = x; k < x + LENGTH; k++) {
                    if (MAP[j][k] == 0) {
                        MAP[j][k] = 1;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (MAP[i][j] == 1) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void input() {
        CNT = SC.nextInt();
        MAP = new int[101][101];
    }
}
