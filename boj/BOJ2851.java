package boj;

public class BOJ2851 {
    static FastReader SC = new FastReader();
    static int[] A = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            A[i] = SC.nextInt();
        }

        int res = 0;
        int sum = 0;
        boolean isUnder100 = true;
        for (int i = 0; i < 10; i++) {
            sum += A[i];
            if (sum == 100) {
                res = sum;
                isUnder100 = false;
                break;
            }
            if (sum > 100) {
                int diff1 = Math.abs(100 - sum);
                int diff2 = Math.abs(100 - (sum - A[i]));
                if (diff1 <= diff2) {
                    res = sum;
                }
                else {
                    res = sum - A[i];
                }
                isUnder100 = false;
                break;
            }
        }

        if (isUnder100) {
            System.out.println(sum);
        }
        else {
            System.out.println(res);
        }
    }
}
