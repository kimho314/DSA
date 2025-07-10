package boj;

public class BOJ18238 {
    static FastReader SC = new FastReader();
    static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        char start = 'A';

        for (int i = 0; i < STR.length(); i++) {
            int step1 = Math.abs(STR.charAt(i) - start);
            int step2 = Math.abs('A' - Math.min(start, STR.charAt(i))) + Math.abs('Z' - Math.max(STR.charAt(i), start)) + 1;
            res += Math.min(step1, step2);

            start = STR.charAt(i);
        }

        System.out.println(res);
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
