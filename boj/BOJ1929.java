package boj;

public class BOJ1929 {
    private static FastReader SC = new FastReader();
    private static int M, N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void input() {
        M = SC.nextInt();
        N = SC.nextInt();
    }
}
