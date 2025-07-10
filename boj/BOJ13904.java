package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ13904 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] SCORES;

    static class Homework {
        int d;
        int w;
    }

    public static void main(String[] args) {
        N = SC.nextInt();
        SCORES = new int[1000 + 1];
        List<Homework> homeworks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Homework homework = new Homework();
            homework.d = SC.nextInt();
            homework.w = SC.nextInt();
            homeworks.add(homework);
        }
        homeworks.sort((o1, o2) -> o2.w - o1.w);

        for (Homework homework : homeworks) {
            if (SCORES[homework.d] == 0) {
                SCORES[homework.d] = homework.w;
            }
            else {
                for (int i = homework.d - 1; i > 0; i--) {
                    if (SCORES[i] == 0) {
                        SCORES[i] = homework.w;
                        break;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= 1000; i++) {
            res += SCORES[i];
        }
        System.out.println(res);
    }

}
