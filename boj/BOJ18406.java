package boj;

public class BOJ18406 {
    static FastReader SC = new FastReader();
    static String N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int len = N.length() / 2;

        int sumLeft = 0;
        for (int i = 0; i < len; i++) {
            sumLeft += Integer.parseInt(String.valueOf((N.charAt(i))));
        }

        int sumRight = 0;
        for (int i = len; i < N.length(); i++) {
            sumRight += Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        if (sumLeft == sumRight) {
            System.out.println("LUCKY");
        }
        else {
            System.out.println("READY");
        }
    }

    private static void input() {
        N = SC.nextLine();
    }
}
