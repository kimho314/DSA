package boj;

public class BOJ4396 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[][] MAP;
    private static char[][] MOVE;
    private static int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        char[][] res = new char[N][N];

        boolean isMine = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MOVE[i][j] == 'x') {
                    if (MAP[i][j] == '*') {
                        isMine = true;
                    }
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int y = i + DIR[k][0];
                        int x = j + DIR[k][1];
                        if (y < 0 || x < 0 || y >= N || x >= N) {
                            continue;
                        }

                        if (MAP[y][x] == '*') {
                            cnt++;
                        }
                    }
                    res[i][j] = String.valueOf(cnt).charAt(0);
                }
                else {
                    res[i][j] = '.';
                }
            }
        }

        if (isMine) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (MAP[i][j] == '*') {
                        res[i][j] = '*';
                    }
                }
            }
        }

        print(res);
    }

    private static void print(char[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < str.length(); j++) {
                MAP[i][j] = str.charAt(j);
            }
        }
        MOVE = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < str.length(); j++) {
                MOVE[i][j] = str.charAt(j);
            }
        }
    }
}
