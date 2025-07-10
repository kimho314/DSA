package boj;

public class BOJ30700 {
    private static FastReader SC = new FastReader();
    private static char[] KOREA = {'K', 'O', 'R', 'E', 'A'};
    private static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 0; i < STR.length(); i++) {
            if (KOREA[cnt % KOREA.length] == STR.charAt(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
