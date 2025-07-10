package boj;

import java.util.Arrays;
import java.util.Comparator;

public class BOJ2304 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] PILLARS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int tail = 0;
        for (int i = 0; i < N; i++) {
            tail = Math.max(PILLARS[i][1], tail);
        }

        Arrays.sort(PILLARS, Comparator.comparingInt(o -> o[0]));

        int start = 0;
        for (int i = 0; i < N; i++) {
            if (PILLARS[i][1] == tail) {
                start = i;
            }
        }

        //tall은 따로 더해줘야 하기 때문에 제일 처음에 넣기
        int size = tail;

        int prevX = PILLARS[0][0];
        int prevH = PILLARS[0][1];

        for (int i = 0; i <= start; i++) {
            if (PILLARS[i][1] >= prevH) {
                size += (PILLARS[i][0] - prevX) * prevH;
                prevX = PILLARS[i][0];
                prevH = PILLARS[i][1];
            }
        }

        prevX = PILLARS[N - 1][0];
        prevH = PILLARS[N - 1][1];

        for (int i = N - 1; i >= start; i--) {
            if (PILLARS[i][1] >= prevH) {
                size += (prevX - PILLARS[i][0]) * prevH;
                prevX = PILLARS[i][0];
                prevH = PILLARS[i][1];
            }
        }

        System.out.println(size);
    }

    private static void input() {
        N = SC.nextInt();
        PILLARS = new int[N][2];
        for (int i = 0; i < N; i++) {
            PILLARS[i][0] = SC.nextInt();
            PILLARS[i][1] = SC.nextInt();
        }
    }
}
