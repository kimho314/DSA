package boj;

public class BOJ2885 {
    private static FastReader SC = new FastReader();
    private static int K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int minSize = 0;
        for (int i = 1; i <= 20; i++) {
            int size = (int) Math.pow(2, i);
            if (size >= K) {
                minSize = size;
                break;
            }
        }


        int cnt = 0;
        if (K == minSize) {
            System.out.println(minSize + " " + cnt);
            return;
        }

        int d = minSize;
        int sum = 0;
        while (true) {
            if (sum == K) {
                break;
            }

            d /= 2;
            int diff = K - sum;
            if (diff >= d) {
                sum += d;
            }
            cnt++;
        }
        System.out.println(minSize + " " + cnt);
    }

    private static void input() {
        K = SC.nextInt();
    }
}
