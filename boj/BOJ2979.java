package boj;

public class BOJ2979 {
    private static FastReader SC = new FastReader();
    private static int A, B, C;
    private static int[] TIME;

    public static void main(String[] args) {
        input();

        for (int i = 0; i < 3; i++) {
            int start = SC.nextInt();
            int end = SC.nextInt();
            count(start, end);
        }

        solve();
    }

    private static void solve() {
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            if (TIME[i] == 1) {
                res += A;
            }
            if (TIME[i] == 2) {
                res += B * 2;
            }
            if (TIME[i] == 3) {
                res += C * 3;
            }
        }

        System.out.println(res);
    }

    private static void count(int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            TIME[i]++;
        }
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
        TIME = new int[101];
    }
}
