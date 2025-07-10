package boj;

public class BOJ2566 {
    static FastReader SC = new FastReader();
    static int[][] MAP = new int[9][9];

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }
    }

    private static void solve() {
        int max = -1;
        int row = -1;
        int col = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < MAP[i][j]) {
                    max = MAP[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
