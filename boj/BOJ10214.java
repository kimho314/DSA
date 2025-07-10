package boj;

public class BOJ10214 {
    private static FastReader SC = new FastReader();
    private static int T;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            T--;

            int scoreK = 0;
            int scoreY = 0;

            for (int i = 0; i < 9; i++) {
                int score1 = SC.nextInt();
                int score2 = SC.nextInt();

                scoreY += score1;
                scoreK += score2;
            }

            if (scoreY > scoreK) {
                sb.append("Yonsei").append("\n");
            }
            else if (scoreY < scoreK) {
                sb.append("Korea").append("\n");
            }
            else {
                sb.append("Draw").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        T = SC.nextInt();
    }
}
