package boj;

public class BOJ10984 {
    private static FastReader SC = new FastReader();
    private static int T;
    private static int[] CREDITS;
    private static double[] GRADES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int t = 0; t < T; t++) {
            int n = SC.nextInt();
            int sumOfC = 0;
            double sumOfG = 0.0;
            for (int i = 0; i < n; i++) {
                int c = SC.nextInt();
                double g = SC.nextDouble();
                sumOfC += c;
                sumOfG += (double) c * g;
            }
            CREDITS[t] = sumOfC;
            GRADES[t] = sumOfG / (double) sumOfC;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(CREDITS[i]).append(' ').append(String.format("%.1f", GRADES[i])).append('\n');
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
        CREDITS = new int[T];
        GRADES = new double[T];
    }
}
