package boj;

import java.util.Arrays;
import java.util.Comparator;

public class BOJ17224 {
    static FastReader SC = new FastReader();
    static int N, L, K;
    static Level[] LEVELS;

    static class Level {
        public int sub1;
        public int sub2;
        public boolean isUsed;
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        int sum = 0;
        Arrays.sort(LEVELS, Comparator.comparing(it -> it.sub2));
        for (int i = N - 1; i >= 0; i--) {
            if (cnt >= K) {
                break;
            }
            if (LEVELS[i].sub2 <= L && !LEVELS[i].isUsed) {
//                System.out.println("cnt = " + cnt + " sum = " + sum + " sub2 = " + LEVELS[i].sub2);
                cnt++;
                sum += 140;
                LEVELS[i].isUsed = true;
            }
        }

        Arrays.sort(LEVELS, Comparator.comparing(it -> it.sub1));
        for (int i = N - 1; i >= 0; i--) {
            if (cnt >= K) {
                break;
            }
            if (LEVELS[i].sub1 <= L && !LEVELS[i].isUsed) {
//                System.out.println("cnt = " + cnt + " sum = " + sum + " sub1 = " + LEVELS[i].sub1);
                cnt++;
                sum += 100;
                LEVELS[i].isUsed = true;
            }
        }

        System.out.println(sum);
    }

    private static void input() {
        N = SC.nextInt();
        L = SC.nextInt();
        K = SC.nextInt();

        LEVELS = new Level[N];
        for (int i = 0; i < N; i++) {
            int sub1 = SC.nextInt();
            int sub2 = SC.nextInt();
            Level level = new Level();
            level.sub1 = sub1;
            level.sub2 = sub2;
            level.isUsed = false;
            LEVELS[i] = level;
        }
    }
}
