package boj;

public class BOJ19949 {
    static FastReader SC = new FastReader();
    static int[] SELECTED = new int[10];
    static int CNT = 0;
    static int[] ANSWERS = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ANSWERS[i] = SC.nextInt();
        }

        recFunc(0);

        System.out.println(CNT);
    }

    private static void recFunc(int k) {
        if (k == 10) {
            int score = 0;
            for (int i = 0; i < 10; i++) {
                if (SELECTED[i] == ANSWERS[i]) {
                    score++;
                }
            }

            if (score >= 5) {
                CNT++;
            }
        }
        else {
            for (int i = 1; i <= 5; i++) {
                if (k < 2 || (i != SELECTED[k - 1] || i != SELECTED[k - 2])) {
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                }
            }
        }
    }
}
