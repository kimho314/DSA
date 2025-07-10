package boj;

public class BOJ10539 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();

        long prev = 0;
        for (int i = 1; i <= N; i++) {
            int n = SC.nextInt();
            long sum = (long) n * (long) i;
            SB.append(sum - prev).append(" ");
            prev = sum;
        }
        System.out.println(SB.toString());
    }
}
