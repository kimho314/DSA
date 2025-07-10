package boj;

public class BOJ28701 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        for (int i = 1; i <= N; i++) {
            sum1 += i;
            sum3 += (i * i * i);
        }
        sum2 = sum1 * sum1;

        StringBuilder sb = new StringBuilder();
        sb.append(sum1).append("\n")
                .append(sum2).append("\n")
                .append(sum3);
        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
    }
}
