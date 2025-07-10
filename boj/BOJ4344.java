package boj;

public class BOJ4344 {
    private static FastReader SC = new FastReader();
    private static int C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (C > 0) {
            C--;

            int n = SC.nextInt();
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = SC.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += scores[i];
            }

            double avg = (double) sum / (double) n;

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if ((double) scores[i] > avg) {
                    cnt++;
                }
            }

            double ratio = ((double) cnt / (double) n) * 100.0;
            double roundedRatio = Math.round(ratio * 1000.0) / 1000.0;
            sb.append(String.format("%.3f", roundedRatio)).append('%').append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        C = SC.nextInt();
    }
}
