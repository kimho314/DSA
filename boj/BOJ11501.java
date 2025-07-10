package boj;

public class BOJ11501 {
    static FastReader SC = new FastReader();
    static int N, T;
    static int[] SHARES;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            N = SC.nextInt();
            SHARES = new int[N];
            for (int i = 0; i < N; i++) {
                SHARES[i] = SC.nextInt();
            }

            long maxProfit = 0;
            int maxShare = SHARES[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (maxShare >= SHARES[i]) {
                    maxProfit += (maxShare - SHARES[i]);
                }
                else {
                    maxShare = SHARES[i];
                }
            }
            SB.append(maxProfit).append('\n');
        }
        System.out.println(SB);
    }
}
