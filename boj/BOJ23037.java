package boj;

public class BOJ23037 {
    private static FastReader SC = new FastReader();
    private static String N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        long sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum += (long) Math.pow(Integer.parseInt(N.charAt(i) + ""), 5);
        }
        System.out.println(sum);
    }

    private static void input() {
        N = SC.nextLine();
    }
}
