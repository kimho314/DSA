package boj;

public class BOJ1051 {
    static FastReader SC = new FastReader();
    static int N, M;
    static char[][] MAP;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        MAP = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] chs = SC.next().toCharArray();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = chs[j];
            }
        }

        int res = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int size = 2; size <= 50; size++) {
                    int posY1 = i;
                    int posX1 = j + size - 1;
                    if (posX1 >= M) {
                        continue;
                    }
                    boolean match1 = MAP[i][j] == MAP[posY1][posX1];

                    int posY2 = i + size - 1;
                    int posX2 = j;
                    if (posY2 >= N) {
                        continue;
                    }
                    boolean match2 = MAP[i][j] == MAP[posY2][posX2];

                    int posY3 = i + size - 1;
                    int posX3 = j + size - 1;
                    if (posY3 >= N || posX3 >= M) {
                        continue;
                    }
                    boolean match3 = MAP[i][j] == MAP[posY3][posX3];

                    if (match1 && match2 && match3) {
                        res = Math.max(res, size * size);
                    }
                }
            }
        }
        System.out.println(res);
    }
}
