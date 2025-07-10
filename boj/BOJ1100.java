package boj;

public class BOJ1100 {
    static FastReader SC = new FastReader();
    static String[][] MAP = new String[8][8];
    static int CNT = 0;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (MAP[i][j].equals("F")) {
                    if (i % 2 == 0 && j % 2 == 0) {
                        CNT++;
                    }
                    if (i % 2 == 1 && j % 2 == 1) {
                        CNT++;
                    }
                }
            }
        }
        System.out.println(CNT);
    }

    private static void input() {
        for (int i = 0; i < 8; i++) {
            String str = SC.nextLine();
            for (int j = 0; j < 8; j++) {
                MAP[i][j] = String.valueOf(str.charAt(j));
            }
        }
    }
}
