package boj;

public class BOJ1789 {
    static FastReader SC = new FastReader();
    static long S;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long result = 0;
        long sum = 0;
        for (int i = 1; i <= S; i++) {
            sum += i;
            result = i;
            if (sum > S) {
                result--;
                break;
            }
        }

        System.out.println(result);
    }

    private static void input() {
        S = SC.nextLong();
    }
}
