package boj;

import java.util.Arrays;

public class BOJ12788 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int M, K;
    private static int[] PENS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int totalPens = M * K;
        int count = 0;

        Arrays.sort(PENS);

        for (int i = N - 1; i >= 0; i--) {
            if (totalPens <= 0) {
                break;
            }

            totalPens -= PENS[i];
            count++;
        }

        if (totalPens > 0) {
            System.out.println("STRESS");
        }
        else {
            System.out.println(count);
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        K = SC.nextInt();
        PENS = new int[N];
        for (int i = 0; i < N; i++) {
            PENS[i] = SC.nextInt();
        }
    }
}
