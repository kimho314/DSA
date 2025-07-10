package boj;

public class BOJ1418 {
    private static FastReader SC = new FastReader();
    private static int N, K;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = 1;
        }

        for (int i = K + 1; i <= N; i++) {
            boolean decimal = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    decimal = false;
                    break;
                }
            }

            if (decimal) {
                int j = 1;
                while (true) {
                    if (i * j > N) {
                        break;
                    }
                    arr[i * j] = 0;
                    j++;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
    }
}
