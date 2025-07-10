package boj;

public class BOJ10157 {
    private static FastReader SC = new FastReader();
    private static int C, R, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] map = new int[R][C];

        if (K > R * C) {
            System.out.println(0);
            return;
        }

        int limitRow = R;
        int limitCol = C - 1;
        int col = 0;
        int row = R;
        int cnt = 1;
        int stepRow = -1;
        int stepCol = 1;

        while (cnt <= R * C) {
            for (int i = 0; i < limitRow; i++) {
                row += stepRow;
                map[row][col] = cnt;
                cnt++;
            }
            stepRow *= -1;
            limitRow--;
            for (int i = 0; i < limitCol; i++) {
                col += stepCol;
                map[row][col] = cnt;
                cnt++;
            }
            stepCol *= -1;
            limitCol--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (K == map[i][j]) {
                    sb.append(j + 1).append(" ").append(R - i);
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        C = SC.nextInt();
        R = SC.nextInt();
        K = SC.nextInt();
    }
}
