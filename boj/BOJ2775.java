package boj;

import java.util.Arrays;

public class BOJ2775 {
    static FastReader SC = new FastReader();
    static int T;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        long[][] rooms = new long[15][15];
        for (int i = 0; i < 15; i++) {
            Arrays.fill(rooms[i], 0);
        }

        for (int i = 1; i < 15; i++) {
            rooms[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                for (int k = 0; k <= j; k++) {
                    rooms[i][j] += rooms[i - 1][k];
                }
            }
        }

        while (T > 0) {
            T--;
            int k = SC.nextInt();
            int n = SC.nextInt();
            SB.append(rooms[k][n]).append('\n');
        }
        System.out.println(SB.toString());
    }
}
