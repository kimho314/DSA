package boj;

public class BOJ1300 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();

        long l = 1;
        long r = K;

        while (l < r) {
            long mid = (l + r) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (K <= count) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }
}
