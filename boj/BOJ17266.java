package boj;

public class BOJ17266 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] X;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        X = new int[M];
        for (int i = 0; i < M; i++) {
            X[i] = SC.nextInt();
        }

        int l = 1, r = 100000;
        int res = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (determination(mid)) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
//        System.out.println();
        System.out.println(res);
    }

    private static boolean determination(int height) {
        int last = 0;  // 밝혀진 마지막 위치
        for (int i = 0; i < M; i++) {
            if (X[i] - last <= height) {
                last = X[i] + height;
            }
            else {
                return false;
            }
        }
        return last >= N;
    }
}
