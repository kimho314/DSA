package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9742 {
    static int N;
    static int CNT;
    static String INPUT;
    static String ANS;
    static boolean[] USED;
    private static char[] CHARS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            input(line);
            solve();
        }
    }

    private static void input(String line) {
        StringTokenizer st = new StringTokenizer(line);
        INPUT = st.nextToken();
        N = Integer.parseInt(st.nextToken());
        CNT = 0;
        USED = new boolean[INPUT.length()];
        CHARS = new char[INPUT.length()];
        ANS = null;
    }

    private static void solve() {
        recFunc(0);

        String res = "No permutation";
        if (ANS != null) {
            res = ANS;
        }
        System.out.println(INPUT + " " + N + " = " + res);
    }

    private static void recFunc(int k) {
        if (k == INPUT.length()) {
//            System.out.println(new String(CHARS));
            CNT++;
            if (CNT == N) {
                ANS = new String(CHARS);
            }
        }
        else {
            for (int i = 0; i < INPUT.length(); i++) {
                if (!USED[i]) {
                    USED[i] = true;
                    CHARS[k] = INPUT.charAt(i);
                    recFunc(k + 1);
                    USED[i] = false;
                }
            }
        }
    }
}
