package boj;

public class BOJ1233 {
    static FastReader SC = new FastReader();
    static int[] S = new int[3];
    static int[] SUMS = new int[81];
//    static int[] SELECTED = new int[3];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            S[i] = SC.nextInt();
        }

        recFunc(1, 0);

        int most = SUMS[0];
        int res = 0;
        for (int i = 1; i <= 80; i++) {
            if (most < SUMS[i]) {
                res = i;
                most = SUMS[i];
            }
        }
        System.out.println(res);
    }

    private static void recFunc(int k, int sum) {
        if (k == 4) {
//            System.out.println(Arrays.toString(SELECTED));
            SUMS[sum]++;
        }
        else {
            for (int i = 1; i <= S[k - 1]; i++) {
//                SELECTED[k - 1] = i;
                recFunc(k + 1, sum + i);
//                SELECTED[k - 1] = 0;
            }
        }
    }
}
