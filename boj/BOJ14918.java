package boj;

public class BOJ14918 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        int[] coins = new int[]{5, 2};
        int res = -1;
        int cnt = 0;

        while (true) {
            int exchange = N;
            int cnt5 = (exchange / coins[0]) - cnt;
            if (cnt5 < 0) {
                break;
            }
            exchange = exchange - (cnt5 * coins[0]);
            int cnt2 = exchange / coins[1];

            if (cnt5 * coins[0] + cnt2 * coins[1] == N) {
                res = cnt5 + cnt2;
                break;
            }
            cnt++;
        }
        System.out.println(res);
    }
}
