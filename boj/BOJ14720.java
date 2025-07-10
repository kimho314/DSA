package boj;

public class BOJ14720 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int round = 1;
        // 0 : strawberry
        // 1 : choco
        // 2 : banana
        int[] milks = new int[3];
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                if (milks[0] == round - 1) {
                    res++;
                    milks[0]++;
                }
            }
            else if (A[i] == 1) {
                if (milks[1] == round - 1 && milks[0] == round) {
                    res++;
                    milks[1]++;
                }
            }
            else {
                if (milks[2] == round - 1 && milks[1] == round && milks[0] == round) {
                    res++;
                    milks[2]++;
                    round++;
                }
            }
        }
        System.out.println(res);
    }
}
