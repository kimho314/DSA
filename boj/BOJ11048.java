package boj;

public class BOJ11048 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[][] MAP, DP;
    static int[][] DIR = {{-1, 0}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new int[N][M];
        DP = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MAP[i][j] = SC.nextInt();
            }
        }

        DP[0][0] = MAP[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    int dy = i + DIR[k][0];
                    int dx = j + DIR[k][1];
                    if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                        continue;
                    }

                    max = Math.max(max, DP[dy][dx]);
                }
                DP[i][j] = max + MAP[i][j];
            }
        }

        System.out.println(DP[N - 1][M - 1]);
    }
}
