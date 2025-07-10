package boj;

public class BOJ19564 {
    private static FastReader SC = new FastReader();
    private static String L;
    private static String STR = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 1;
        int prevIdx = STR.indexOf(String.valueOf(L.charAt(0)));

        for (int i = 1; i < L.length(); i++) {
            int idx = STR.indexOf(String.valueOf(L.charAt(i)));
//            System.out.println(prevIdx + " " + idx);
            if (idx <= prevIdx) {
                cnt++;
            }
            prevIdx = idx;
        }

        System.out.println(cnt);
    }

    private static void input() {
        L = SC.nextLine();
    }
}
