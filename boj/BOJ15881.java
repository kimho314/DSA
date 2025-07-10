package boj;

public class BOJ15881 {
    static FastReader SC = new FastReader();
    static int N;
    static String INPUT;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String str = "pPAp";
        String replaced = INPUT.replaceAll(str, "-");

        int cnt = 0;
        for (int i = 0; i < replaced.length(); i++) {
            if (replaced.charAt(i) == '-') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        N = SC.nextInt();
        INPUT = SC.nextLine();
    }
}
