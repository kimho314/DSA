package boj;

public class BOJ15786 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static String TARGET;
    private static String[] INPUTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int idx = 0;
            String str = INPUTS[i];
            for (char ch : str.toCharArray()) {
//                System.out.println(ch + " " + idx + " " + TARGET.charAt(idx));
                if (idx <= TARGET.length() - 1 && ch == TARGET.charAt(idx)) {
                    idx++;
                }
            }

            if (idx == N) {
                sb.append(true).append('\n');
            } else {
                sb.append(false).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        TARGET = SC.next();
        INPUTS = new String[M];
        for (int i = 0; i < M; i++) {
            INPUTS[i] = SC.next();
        }
    }
}
