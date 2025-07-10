package boj;

public class BOJ2961 {
    static FastReader SC = new FastReader();
    static int[][] TASTES;
    static int N;
    static int[] SELECTED;
    static int MIN_DIFF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();
        SELECTED = new int[N + 1];
        TASTES = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            int sour = SC.nextInt();
            int bitter = SC.nextInt();
            TASTES[i][0] = sour;
            TASTES[i][1] = bitter;
        }

        for (int i = 1; i <= N; i++) {
            recFunc(1, i, 0, 1, 0);
//            System.out.println("============");
        }
        System.out.println(MIN_DIFF);
    }

    private static void recFunc(int k, int length, int prevIdx, int sours, int bitters) {
        if (k == length + 1) {
//            int[] copied = Arrays.copyOfRange(SELECTED, 1, length + 1);
//            System.out.println(Arrays.toString(copied));
//            for (int idx : copied) {
//                System.out.println(TASTES[idx][0] + " " + TASTES[idx][1]);
//            }
            int diff = Math.abs(sours - bitters);
            MIN_DIFF = Math.min(MIN_DIFF, diff);
        }
        else {
            for (int i = prevIdx + 1; i <= N; i++) {
                SELECTED[k] = i;
                recFunc(k + 1, length, i, sours * TASTES[i][0], bitters + TASTES[i][1]);
                SELECTED[k] = 0;
            }
        }
    }
}
