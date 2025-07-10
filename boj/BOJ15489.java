package boj;

public class BOJ15489 {
    private static FastReader SC = new FastReader();
    private static int R, C, W;
    private static int[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += MAP[R - 1 + i][C - 1 + j];
            }
        }

        System.out.println(sum);
    }

    private static void input() {
        R = SC.nextInt();
        C = SC.nextInt();
        W = SC.nextInt();
        MAP = new int[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    MAP[i][j] = 1;
                } else {
                    MAP[i][j] = MAP[i - 1][j] + MAP[i - 1][j - 1];
                }
            }
        }
    }
}
