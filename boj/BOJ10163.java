package boj;

public class BOJ10163 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] MAP;
    private static int[][] PAPERS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int x = PAPERS[i][0];
            int y = PAPERS[i][1];
            int w = PAPERS[i][2];
            int h = PAPERS[i][3];
            for (int j = y; j < y + h; j++) {
                for (int k = x; k < x + w; k++) {
                    MAP[j][k] = i + 1;
                }
            }
        }

        int[] cnt = new int[N];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (MAP[i][j] > 0) {
                    cnt[MAP[i][j] - 1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(cnt[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        MAP = new int[1001][1001];
        N = SC.nextInt();
        PAPERS = new int[N][4];
        for (int i = 0; i < N; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            int w = SC.nextInt();
            int h = SC.nextInt();
            PAPERS[i][0] = x;
            PAPERS[i][1] = y;
            PAPERS[i][2] = w;
            PAPERS[i][3] = h;
        }
    }
}
