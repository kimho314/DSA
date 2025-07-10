package boj;

public class BOJ10822 {
    private static FastReader SC = new FastReader();
    private static String S;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] split = S.split(",");

        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }

    private static void input() {
        S = SC.nextLine();
    }
}
