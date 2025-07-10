package boj;

import java.util.Arrays;

public class BOJ1141 {
    static FastReader SC = new FastReader();
    static int N;
    static int ANSWER;
    static String[] WORDS;
    static boolean[] CONTAINED;

    public static void main(String[] args) {
        N = SC.nextInt();
        WORDS = new String[N];
        CONTAINED = new boolean[N];
        for (int i = 0; i < N; i++) {
            WORDS[i] = SC.nextLine();
        }

        Arrays.sort(WORDS);

        for (int i = N - 1; i >= 0; i--) {
            boolean ok = true;
            for (int j = i + 1; j < N; j++) {
                if (CONTAINED[j] && WORDS[j].startsWith(WORDS[i])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                CONTAINED[i] = true;
                ANSWER++;
            }
        }

        System.out.println(ANSWER);
    }
}
