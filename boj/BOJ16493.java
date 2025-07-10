package boj;

public class BOJ16493 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static Chapter[] CHAPTERS;

    private static class Chapter implements Comparable<Chapter> {
        int days;
        int pages;

        public Chapter(int days, int pages) {
            this.days = days;
            this.pages = pages;
        }

        @Override
        public int compareTo(Chapter o) {
            if (this.pages == o.pages) {
                return this.days - o.days;
            }
            return o.pages - pages;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j];
                int days = CHAPTERS[i].days;
                int pages = CHAPTERS[i].pages;
                if (j >= days) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - days] + pages);
                }
            }
        }

        System.out.println(dp[M][N]);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        CHAPTERS = new Chapter[M + 1];
        for (int i = 1; i <= M; i++) {
            CHAPTERS[i] = new Chapter(SC.nextInt(), SC.nextInt());
        }
    }
}
