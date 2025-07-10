package boj;

public class BOJ2828 {
    static FastReader SC = new FastReader();
    static int N, M, J;
    static int[] POS;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        J = SC.nextInt();
        POS = new int[J];
        for (int i = 0; i < J; i++) {
            POS[i] = SC.nextInt();
        }

        int res = 0;
        int left = 1;
        int right = left + M - 1;
        for (int i = 0; i < J; i++) {
            if (POS[i] < left) {
                res += left - POS[i];
                left = POS[i];
                right = left + M - 1;
            }
            if (POS[i] > right) {
                res += POS[i] - right;
                right = POS[i];
                left = right - M + 1;
            }
        }
        System.out.println(res);
    }
}
