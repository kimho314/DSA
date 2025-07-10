package boj;

public class BOJ17427 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();

        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += (long) (N / i) * i;
        }
        System.out.println(ans);
    }
}
