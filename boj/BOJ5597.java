package boj;

public class BOJ5597 {
    private static FastReader SC = new FastReader();
    private static boolean[] STUDENTS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!STUDENTS[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void input() {
        STUDENTS = new boolean[31];
        for (int i = 0; i < 28; i++) {
            STUDENTS[SC.nextInt()] = true;
        }
    }
}
