package boj;

public class BOJ2581 {
    private static FastReader SC = new FastReader();
    private static int N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        M = SC.nextInt();
        N = SC.nextInt();
    }

    private static void solve() {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                // System.out.println(i);
                sum += i;
                min = Math.min(min, i);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

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
}
