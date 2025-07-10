package boj;

public class BOJ17521 {
    static FastReader SC = new FastReader();
    static int N, W;
    static int[] PRICE;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int money = W;

        for (int i = 0; i < N - 1; i++) {
            if (PRICE[i] < PRICE[i + 1]) {
                int coin = money / PRICE[i];
                money -= coin * PRICE[i];
                money += coin * PRICE[i + 1];
            }
        }
        System.out.println(money);
    }

    private static void input() {
        N = SC.nextInt();
        W = SC.nextInt();
        PRICE = new int[N];
        for (int i = 0; i < N; i++) {
            PRICE[i] = SC.nextInt();
        }
    }
}
