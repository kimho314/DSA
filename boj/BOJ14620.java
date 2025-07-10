package boj;

public class BOJ14620 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] GARDEN;
    private static boolean[][] VISITED;
    private static int ANS = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        plant(0, 0);
        System.out.println(ANS);
    }

    private static void plant(int sum, int cnt) {
        int[] dx = {0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, -1, 1};

        if (cnt == 3) {
            ANS = Math.min(sum, ANS);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                boolean isAvailable = true;

                for (int k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (VISITED[nx][ny]) {
                        isAvailable = false;
                        break;
                    }
                }

                if (isAvailable) {
                    int result = 0;
                    for (int k = 0; k < 5; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        result += GARDEN[nx][ny];
                        VISITED[nx][ny] = true;
                    }

                    plant(sum + result, cnt + 1);

                    for (int k = 0; k < 5; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        VISITED[nx][ny] = false;
                    }
                }
            }
        }
    }

    private static void input() {
        N = SC.nextInt();
        GARDEN = new int[N][N];
        VISITED = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                GARDEN[i][j] = SC.nextInt();
            }
        }
    }
}
