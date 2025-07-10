package boj;

public class BOJ1652 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[][] MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[][] visited = new boolean[N][N];
        int rowCnt = getRowCnt(visited);

        visited = new boolean[N][N];
        int colCnt = getColCnt(visited);

        System.out.println(rowCnt + " " + colCnt);
    }

    private static int getColCnt(boolean[][] visited) {
        int colCnt = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j][i]) {
                    visited[j][i] = true;
                    if (MAP[j][i] != 'X') {
                        cnt++;
                    }
                    else {
                        if (cnt >= 2) {
                            colCnt++;
                        }
                        cnt = 0;
                    }
                }
            }

            if (cnt >= 2) {
                colCnt++;
            }
        }
        return colCnt;
    }

    private static int getRowCnt(boolean[][] visited) {
        int rowCnt = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (MAP[i][j] != 'X') {
                        cnt++;
                    }
                    else {
                        if (cnt >= 2) {
                            rowCnt++;
                        }
                        cnt = 0;
                    }
                }
            }
            if (cnt >= 2) {
                rowCnt++;
            }
        }
        return rowCnt;
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < N; j++) {
                MAP[i][j] = str.charAt(j);
            }
        }
    }
}
