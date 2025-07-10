package boj;

public class BOJ24060 {
    static FastReader SC = new FastReader();
    static int[] A;
    static int[] TMP;
    static int K;
    static int CNT = 0;
    static int RESULT = -1;

    public static void mergeSort(int[] A, int p, int r) {
        if (CNT > K) {
            return;
        }
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] < A[j]) {
                TMP[t++] = A[i++];
            }
            else {
                TMP[t++] = A[j++];
            }
        }

        while (i <= q) {
            TMP[t] = A[i];
            t++;
            i++;
        }
        while (j <= r) {
            TMP[t++] = A[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            CNT++;

            if (CNT == K) {
                RESULT = TMP[t];
            }

            A[i++] = TMP[t++];
        }
    }

    public static void main(String[] args) {
        int n = SC.nextInt();
        A = new int[n];
        K = SC.nextInt();
        for (int i = 0; i < n; i++) {
            A[i] = SC.nextInt();
        }
        TMP = new int[n];

        mergeSort(A, 0, n - 1);
        System.out.println(RESULT);
    }
}
