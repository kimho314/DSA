package boj;

public class BOJ25304 {
    private static FastReader SC = new FastReader();
    private static int X, N;
    private static int[] PRICES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += PRICES[i];
        }

        if (X == sum) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    private static void input() {
        X = SC.nextInt();
        N = SC.nextInt();
        PRICES = new int[N];
        for (int i = 0; i < N; i++) {
            int price = SC.nextInt();
            int number = SC.nextInt();
            PRICES[i] = price * number;
        }
    }
}
