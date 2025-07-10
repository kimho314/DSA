package boj;

public class BOJ15658 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;
    static int[] OPS;
    static int[] SELECTED;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        SELECTED = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
        OPS = new int[5];
        for (int i = 1; i <= 4; i++) {
            OPS[i] = SC.nextInt();
        }

        recFunc(1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void recFunc(int k) {
        if (k == N) {
//            System.out.println(Arrays.toString(Arrays.copyOfRange(SELECTED, 1, SELECTED.length)));
            int sum = A[0];
            for (int i = 1; i < N; i++) {
                switch (SELECTED[i]) {
                    case 1:
                        sum += A[i];
                        break;
                    case 2:
                        sum -= A[i];
                        break;
                    case 3:
                        sum *= A[i];
                        break;
                    case 4:
                        sum /= A[i];
                        break;
                }
            }
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
//            System.out.println(MAX + " " + MIN);
        }
        else {
            for (int i = 1; i <= 4; i++) {
                if (OPS[i] > 0) {
                    OPS[i]--;
                    SELECTED[k] = i;
                    recFunc(k + 1);
                    SELECTED[k] = 0;
                    OPS[i]++;
                }
            }
        }
    }
}
