package boj;

import java.util.Arrays;

public class BOJ1759 {
    static FastReader SC = new FastReader();
    static int L, C;
    static String[] A, SELECTED;
    static StringBuilder SB = new StringBuilder();
    static boolean[] USED;
    static String[] VOWEL = new String[]{"a", "e", "i", "o", "u"};

    public static void main(String[] args) {
        L = SC.nextInt();
        C = SC.nextInt();
        A = new String[C];
        USED = new boolean[C];
        SELECTED = new String[L + 1];
        for (int i = 0; i < C; i++) {
            A[i] = SC.next();
        }

        Arrays.fill(SELECTED, "");
        Arrays.sort(A);
        recFunc(1, 0);
        System.out.println(SB);
    }

    private static void recFunc(int k, int prevIdx) {
        if (k == L + 1) {
            int vowels = 0;
            int consonants = 0;
            for (int i = 1; i <= L; i++) {
                boolean hasVowel = false;
                for (int j = 0; j < 5; j++) {
                    if (VOWEL[j].equals(SELECTED[i])) {
                        hasVowel = true;
                        break;
                    }
                }
                if (!hasVowel) {
                    consonants++;
                }
                else {
                    vowels++;
                }
            }

            if (vowels >= 1 && consonants >= 2) {
                for (int i = 1; i <= L; i++) {
                    SB.append(SELECTED[i]);
                }
                SB.append('\n');
            }
        }
        else {
            for (int i = prevIdx; i < C; i++) {
                if (USED[i]) {
                    continue;
                }

                SELECTED[k] = A[i];
                USED[i] = true;
                recFunc(k + 1, i);
                SELECTED[k] = "";
                USED[i] = false;
            }
        }
    }
}
