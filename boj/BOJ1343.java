package boj;

public class BOJ1343 {
    private static FastReader SC = new FastReader();
    private static String STR;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        STR = STR.replaceAll("XXXX", "AAAA");
        STR = STR.replaceAll("XX", "BB");

        boolean isPossible = true;
        for (char ch : STR.toCharArray()) {
            if (ch == 'X') {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            System.out.println(-1);
        }
        else {
            System.out.println(STR);
        }
    }

    private static void input() {
        STR = SC.nextLine();
    }
}
