package boj;

public class BOJ9610 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] POS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int[] ans = new int[5];

        for (int i = 0; i < N; i++) {
            if (POS[i][0] == 0 || POS[i][1] == 0) {
                ans[4]++;
            } else if (POS[i][0] > 0 && POS[i][1] > 0) {
                ans[0]++;
            } else if (POS[i][0] > 0 && POS[i][1] < 0) {
                ans[3]++;
            } else if (POS[i][0] < 0 && POS[i][1] > 0) {
                ans[1]++;
            } else {
                ans[2]++;
            }
        }


        System.out.println("Q1: " + ans[0]);
        System.out.println("Q2: " + ans[1]);
        System.out.println("Q3: " + ans[2]);
        System.out.println("Q4: " + ans[3]);
        System.out.println("AXIS: " + ans[4]);
    }

    private static void input() {
        N = SC.nextInt();
        POS = new int[N][2];
        for (int i = 0; i < N; i++) {
            int x = SC.nextInt();
            int y = SC.nextInt();
            POS[i][0] = x;
            POS[i][1] = y;
        }
    }
}
