package boj;

public class BOJ14215 {
    static FastReader SC = new FastReader();
    static int[] L = new int[3];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            L[i] = SC.nextInt();
        }


        int maxIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (L[maxIdx] < L[i]) {
                maxIdx = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (i == maxIdx) {
                continue;
            }
            sum += L[i];
        }

        int res = 0;
        if (L[maxIdx] < sum) {
            for (int i = 0; i < 3; i++) {
                res += L[i];
            }
        }
        else {
            res = sum + sum - 1;
        }

        System.out.println(res);
    }
}
