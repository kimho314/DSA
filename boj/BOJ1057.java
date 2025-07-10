package boj;

public class BOJ1057 {
    private static FastReader SC = new FastReader();
    private static int N, KIM, LIM;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int round = 0;

        while (KIM != LIM) {
            round++;
            KIM = KIM / 2 + KIM % 2;
            LIM = LIM / 2 + LIM % 2;
        }

        System.out.println(round);
    }

    private static void input() {
        N = SC.nextInt();
        KIM = SC.nextInt();
        LIM = SC.nextInt();
    }
}
