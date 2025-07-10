package boj;

public class BOJ1913 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int TARGET;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] arr = new int[N][N];
        int cnt = 1;
        int y = N / 2;
        int x = N / 2;
        int r = 1;
        int c = 1;
        int dirR = -1;
        int dirC = 1;
        arr[y][x] = cnt;

        while (true) {
            boolean isEnd = false;
            for (int i = 0; i < r; i++) {
                y += dirR;
                ++cnt;
                arr[y][x] = cnt;
                if (cnt == N * N) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) {
                break;
            }
            ++r;
            dirR *= -1;

            for (int i = 0; i < c; i++) {
                x += dirC;
                ++cnt;
                arr[y][x] = cnt;
            }
            ++c;
            dirC *= -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] == TARGET) {
                    sb.append(i + 1).append(" ").append(j + 1);
                }
            }
            System.out.println();
        }
        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        TARGET = SC.nextInt();
    }
}