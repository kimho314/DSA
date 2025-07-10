package boj;

public class BOJ13300 {
    private static FastReader SC = new FastReader();
    private static int[][] STUDENTS;
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++) {
                res += STUDENTS[i][j] / K;
                if (STUDENTS[i][j] % K > 0) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        STUDENTS = new int[7][2];
        for (int i = 0; i < N; i++) {
            int s = SC.nextInt();
            int y = SC.nextInt();
            STUDENTS[y][s]++;
        }
    }
}
