package boj;

import java.util.Arrays;
import java.util.Comparator;

public class BOJ17262 {
    static FastReader SC = new FastReader();
    static int N;

    static class Fan {
        public int s;
        public int e;

        public Fan(int s, int e) {
            this.s = s;
            this.e = e;

        }
    }

    static Fan[] FANS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(FANS, Comparator.comparing(it -> it.s));
        Fan lastFan = FANS[N - 1];
        Arrays.sort(FANS, Comparator.comparing(it -> it.e));
        Fan earliestFan = FANS[0];

        int timeDiff = lastFan.s - earliestFan.e;
        if (timeDiff < 0) {
            System.out.println(0);
        }
        else {
            System.out.println(timeDiff);
        }
    }

    private static void input() {
        N = SC.nextInt();
        FANS = new Fan[N];
        for (int i = 0; i < N; i++) {
            int s = SC.nextInt();
            int e = SC.nextInt();

            Fan fan = new Fan(s, e);
            FANS[i] = fan;
        }
    }
}
