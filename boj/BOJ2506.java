package boj;

public class BOJ2506 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] SCORES;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int totalScore = 0;
        int curScore = 0;

        for (int i = 0; i < N; i++) {
            if (SCORES[i] == 1) {
                curScore++;
                totalScore += curScore;
            }
            else {
                curScore = 0;
            }
        }

        System.out.println(totalScore);
    }

    private static void input() {
        N = SC.nextInt();
        SCORES = new int[N];
        for (int i = 0; i < N; i++) {
            SCORES[i] = SC.nextInt();
        }
    }
}
