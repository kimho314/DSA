package boj;

public class BOJ10039 {
    private static FastReader SC = new FastReader();
    private static int[] SCORES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int avg = 0;
        for (int i = 0; i < 5; i++) {
            if (SCORES[i] < 40) {
                avg += 40;
            }
            else {
                avg += SCORES[i];
            }
        }

        avg = avg / 5;
        System.out.println(avg);
    }

    private static void input() {
        SCORES = new int[5];
        for (int i = 0; i < 5; i++) {
            SCORES[i] = SC.nextInt();
        }
    }
}
