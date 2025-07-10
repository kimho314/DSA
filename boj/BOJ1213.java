package boj;

public class BOJ1213 {
    private static FastReader SC = new FastReader();
    private static int[] CHARS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int oddCnt = 0;
        int middle = 0;

        for (int i = 0; i < 26; i++) {
            if (CHARS[i] % 2 != 0) {
                oddCnt++;
                middle = i;
            }
        }

        if (oddCnt >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < CHARS[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString();

        if (oddCnt == 1) {
            front += (char) (middle + 'A');
        }

        String back = sb.reverse().toString();

        System.out.println(front + back);
    }

    private static void input() {
        String input = SC.next();
        CHARS = new int[26];
        for (int i = 0; i < input.length(); i++) {
            CHARS[input.charAt(i) - 'A']++;
        }
    }
}
