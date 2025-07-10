package boj;

import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1546 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] SCORES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(SCORES);
        int max = SCORES[N - 1];

        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double newScore = ((double) SCORES[i] / (double) max) * 100.0;
            list.add(newScore);
        }

        double avg = 0.0;
        for (Double score : list) {
            avg += score;
        }
        avg /= list.size();

        System.out.println(avg);
    }

    private static void input() {
        N = SC.nextInt();
        SCORES = new int[N];
        for (int i = 0; i < N; i++) {
            SCORES[i] = SC.nextInt();
        }
    }
}
