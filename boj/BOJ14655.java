package boj;

import java.util.Arrays;

public class BOJ14655 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] FIRST, SECOND;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            if (FIRST[i] < 0) {
                int count = 0;
                while (count < 3) {
                    if (i + count > N - 1) {
                        break;
                    }
                    else {
                        FIRST[i + count] *= -1;
                        count++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (SECOND[i] > 0) {
                int count = 0;
                while (count < 3) {
                    if (i + count > N - 1) {
                        break;
                    }
                    else {
                        SECOND[i + count] *= -1;
                        count++;
                    }
                }
            }
        }

        int sum1 = Arrays.stream(FIRST).sum();
        int sum2 = Arrays.stream(SECOND).sum() * -1;
        System.out.println(sum1 + sum2);
    }


    private static void input() {
        N = SC.nextInt();
        FIRST = new int[N];
        SECOND = new int[N];
        for (int i = 0; i < N; i++) {
            FIRST[i] = SC.nextInt();
        }
        for (int i = 0; i < N; i++) {
            SECOND[i] = SC.nextInt();
        }
    }
}
