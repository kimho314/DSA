package boj;

public class BOJ14487 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] V;

    public static void main(String[] args) {
        N = SC.nextInt();
        V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = SC.nextInt();
        }

        int max = 0;
        for (int i = 1; i < N; i++) {
            if (V[max] < V[i]) {
                max = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i == max) {
                continue;
            }
            sum += V[i];
        }
        System.out.println(sum);
    }
}
