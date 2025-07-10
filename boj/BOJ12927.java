package boj;

public class BOJ12927 {
    static FastReader SC = new FastReader();
    static char[] CHARS;
    static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (CHARS[i] == 'N') {
                continue;
            }
            CHARS[i] = 'N';
            cnt++;
            if (i == N) {
                break;
            }
            for (int j = i + 1; j <= N; j++) {
                if (j % i == 0) {
                    if (CHARS[j] == 'Y') {
                        CHARS[j] = 'N';
                    }
                    else {
                        CHARS[j] = 'Y';
                    }
                }
            }
        }

        boolean isAllN = true;
        for (int i = 1; i <= N; i++) {
            if (CHARS[i] == 'Y') {
                isAllN = false;
                break;
            }
        }

        if (!isAllN) {
            System.out.println(-1);
        }
        else {
            System.out.println(cnt);
        }
    }

    private static void input() {
        String input = SC.nextLine();
        N = input.length();
        CHARS = new char[input.length() + 1];
        for (int i = 1; i <= input.length(); i++) {
            CHARS[i] = input.charAt(i - 1);
        }
    }
}
