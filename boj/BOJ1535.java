package boj;

public class BOJ1535 {
    static FastReader SC = new FastReader();
    static int N;
    static int MAX_HEALTH = 100;
    static int[] LOOSE_HEALTH, GAIN_JOY;
    static int[] DP = new int[100];

    public static void main(String[] args) {
        N = SC.nextInt();
        LOOSE_HEALTH = new int[N];
        GAIN_JOY = new int[N];
        for (int i = 0; i < N; i++) {
            LOOSE_HEALTH[i] = SC.nextInt();
        }
        for (int i = 0; i < N; i++) {
            GAIN_JOY[i] = SC.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= LOOSE_HEALTH[i]; j--) {
                DP[j] = Math.max(DP[j], DP[j - LOOSE_HEALTH[i]] + GAIN_JOY[i]);
            }
        }
        System.out.println(DP[99]);
    }
}
