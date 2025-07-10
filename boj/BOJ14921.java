package boj;

public class BOJ14921 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int left = 0;
        int right = N - 1;
        int sum = Integer.MAX_VALUE;
        while (left < right) {
            int curSum = A[left] + A[right];
            if (Math.abs(curSum) < Math.abs(sum)) {
                sum = curSum;
            }

            if (curSum > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        System.out.println(sum);
    }
}
