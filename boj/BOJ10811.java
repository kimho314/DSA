package boj;

public class BOJ10811 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static int[] BASKET;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int cnt = 0; cnt < M; cnt++) {
            int i = SC.nextInt() - 1;
            int j = SC.nextInt() - 1;

            for (int k = i; k <= (j + i) / 2; k++) {
                int tmp = BASKET[j - k + i];
                BASKET[j - k + i] = BASKET[k];
                BASKET[k] = tmp;
            }
        }
        print(BASKET);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        BASKET = new int[N];
        for (int i = 0; i < N; i++) {
            BASKET[i] = i + 1;
        }
    }
}
