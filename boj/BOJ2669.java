package boj;

public class BOJ2669 {
    private static FastReader SC = new FastReader();
    private static int[][] POSES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] map = new int[101][101];

        for (int i = 0; i < 4; i++) {
            int x1 = POSES[i][0];
            int y1 = POSES[i][1];
            int x2 = POSES[i][2];
            int y2 = POSES[i][3];

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                res += map[i][j];
            }
        }

        System.out.println(res);
    }

    private static void input() {
        POSES = new int[4][4];
        for (int i = 0; i < 4; i++) {
            int x1 = SC.nextInt();
            int y1 = SC.nextInt();
            int x2 = SC.nextInt();
            int y2 = SC.nextInt();

            POSES[i][0] = x1;
            POSES[i][1] = y1;
            POSES[i][2] = x2;
            POSES[i][3] = y2;
        }
    }
}
