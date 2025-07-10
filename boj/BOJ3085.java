package boj;

public class BOJ3085 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = check();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1 && MAP[i][j] != MAP[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    int cnt = check();
                    res = Math.max(res, cnt);
                    swap(i, j, i, j + 1);
                }

                if (i < N - 1 && MAP[i][j] != MAP[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    int cnt = check();
                    res = Math.max(res, cnt);
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(res);
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        char temp = MAP[y2][x2];
        MAP[y2][x2] = MAP[y1][x1];
        MAP[y1][x1] = temp;
    }

    private static int check() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (MAP[i][j] == MAP[i][j + 1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                res = Math.max(cnt, res);
            }

            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (MAP[j][i] == MAP[j + 1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                res = Math.max(res, cnt);
            }
        }

        return res;
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
    }
}
