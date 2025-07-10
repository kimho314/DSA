package boj;

public class BOJ2789 {
    static FastReader SC = new FastReader();
    static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String compare = "CAMBRIDGE";
        String res = INPUT;
        for (int i = 0; i < compare.length(); i++) {
            res = res.replace(compare.charAt(i), ' ');
        }

        res = res.replaceAll(" ", "");
        System.out.println(res);
    }

    private static void input() {
        INPUT = SC.nextLine();
    }
}
