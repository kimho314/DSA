package boj;

public class BOJ3040 {
    static FastReader SC = new FastReader();
    static int[] A = new int[9];
    static int[] SELECTED = new int[8];
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            A[i] = SC.nextInt();
        }

        recFunc(1, -1);
        System.out.println(SB.toString());
    }

    private static void recFunc(int k, int prevIdx) {
        if (k == 8) {
            int sum = 0;
            for (int i = 1; i < 8; i++) {
                sum += SELECTED[i];
            }
//            System.out.println(Arrays.toString(Arrays.copyOfRange(SELECTED, 1, SELECTED.length)) + " " + sum);
            if (sum == 100) {
                for (int i = 1; i < 8; i++) {
                    SB.append(SELECTED[i]).append('\n');
                }
            }
        }
        else {
            for (int i = prevIdx + 1; i < 9; i++) {
                SELECTED[k] = A[i];
                recFunc(k + 1, i);
                SELECTED[k] = 0;
            }
        }
    }
}
