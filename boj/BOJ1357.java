package boj;

public class BOJ1357 {
    static FastReader SC = new FastReader();
    static int X, Y;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int revX = rev(X);
        int revY = rev(Y);
        int res = rev(revX + revY);

        System.out.println(res);
    }

    private static int rev(int n) {
        String num = String.valueOf(n);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            res.append(num.charAt(num.length() - 1 - i));
        }

        return Integer.parseInt(res.toString());
    }

    private static void input() {
        X = SC.nextInt();
        Y = SC.nextInt();
    }
}
