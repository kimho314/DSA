package boj;

public class BOJ19939 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();

        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += i;
        }

        if (sum > N) {
            System.out.println(-1);
        }
        else {
            int answer = K - 1;
            N -= sum;
            if (N % K != 0) {
                answer++;
            }
            System.out.println(answer);
        }
    }
}