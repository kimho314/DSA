package boj;

public class BOJ2902 {
    static FastReader SC = new FastReader();
    static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] split = STR.split("-");
        StringBuilder sb = new StringBuilder();
        for (String elem : split) {
            sb.append(elem.charAt(0));
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
