package boj;

public class BOJ9996 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static String TARGET;
    private static String[] STRINGS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        String[] split = TARGET.split("\\*");
        String start = split[0];
        String end = split[1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = STRINGS[i];
            boolean match1 = true;
            int idx = -1;
            for (int j = 0; j < start.length(); j++) {
                if (str.charAt(j) != start.charAt(j)) {
                    match1 = false;
                    break;
                }
                idx = j;
            }

            boolean match2 = true;
            for (int j = 0; j < end.length(); j++) {
                if (str.charAt(str.length() - 1 - j) != end.charAt(end.length() - 1 - j) || str.length() - 1 - j == idx) {
                    match2 = false;
                    break;
                }
            }


            if (match1 && match2) {
                sb.append("DA").append("\n");
            }
            else {
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        TARGET = SC.next();
        STRINGS = new String[N];
        for (int i = 0; i < N; i++) {
            STRINGS[i] = SC.next();
        }
    }
}
